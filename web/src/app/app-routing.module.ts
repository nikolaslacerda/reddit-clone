import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './core/auth/login/login.component';
import { SignupComponent } from './core/auth/signup/signup.component';
import { UserProfileComponent } from './core/auth/user-profile/user-profile.component';
import { AuthGuard } from './core/guards/auth.guard';
import { HomeComponent } from './pages/home/home.component';
import { CreatePostComponent } from './pages/post/create-post/create-post.component';
import { ViewPostComponent } from './pages/post/view-post/view-post.component';
import { CreateSubredditComponent } from './pages/subreddit/create-subreddit/create-subreddit.component';
import { ListSubredditsComponent } from './pages/subreddit/list-subreddits/list-subreddits.component';



const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: "sign-up", component: SignupComponent },
  { path: "login", component: LoginComponent },
  { path: 'create-post', component: CreatePostComponent, canActivate: [AuthGuard] },
  { path: 'create-subreddit', component: CreateSubredditComponent, canActivate: [AuthGuard] },
  { path: 'list-subreddits', component: ListSubredditsComponent },
  { path: 'view-post/:id', component: ViewPostComponent },
  { path: 'user-profile/:name', component: UserProfileComponent, canActivate: [AuthGuard] },
  { path: 'view-subreddit', component: HomeComponent}, ]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
