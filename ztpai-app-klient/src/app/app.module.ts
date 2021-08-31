import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { FormsModule } from '@angular/forms';
import { ForumComponent } from './forum/forum.component';
import { TopicComponent } from './topic/topic.component';
import { PostComponent } from './post/post.component';



@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ForumComponent,
    TopicComponent,
    PostComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
