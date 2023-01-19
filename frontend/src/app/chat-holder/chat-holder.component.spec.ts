import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatHolderComponent } from './chat-holder.component';

describe('ChatHolderComponent', () => {
  let component: ChatHolderComponent;
  let fixture: ComponentFixture<ChatHolderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChatHolderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChatHolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
