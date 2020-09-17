import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HomeComponent } from './home/home.component';
import { ViewPostComponent } from './post/view-post/view-post.component';
import { CreatePostComponent } from './subreddit/create-post/create-post.component';
import { CreateSubredditComponent } from './subreddit/create-subreddit/create-subreddit.component';
import { ListSubredditsComponent } from './subreddit/list-subreddits/list-subreddits.component';


const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: "sign-up", component: SignupComponent },
  { path: "login", component: LoginComponent },
  { path: 'create-post', component: CreatePostComponent },
  { path: 'create-subreddit', component: CreateSubredditComponent },
  { path: 'list-subreddits', component: ListSubredditsComponent },
  { path: 'view-post/:id', component: ViewPostComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
