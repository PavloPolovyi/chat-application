import {Observable, of} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environment/environment";

export abstract class AbstractService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': environment.contentType })
  };

  private readonly httpClient: HttpClient;

  protected constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  get client() {
    return this.httpClient;
  }

  handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
