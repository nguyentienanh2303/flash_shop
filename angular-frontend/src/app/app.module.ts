import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router'
import {FormsModule} from '@angular/forms';
import {ProductService} from './services/product.service';
import {CartService} from './services/cart.service';
import {SecurityService} from './services/security.service';
import {ShareDateService} from './services/share-date.service';
import {UserService} from './services/user.service';
import {HttpClientModule} from '@angular/common/http';

import {VNDONG} from './pipes/vndong.pipe';
import {SUMMARY} from './pipes/summary.pipe';
import {CARTMONEY} from './pipes/cartmoney.pipe';

 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SlideComponent } from './slide/slide.component';
import { FooterComponent } from './footer/footer.component';
import { LienHeMessengerComponent } from './lien-he-messenger/lien-he-messenger.component';
import { ViewMainComponent } from './view-main/view-main.component';
import { ContactComponent } from './contact/contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SSDComponent } from './ssd/ssd.component';
import { RAMComponent } from './ram/ram.component';
import { CPUComponent } from './cpu/cpu.component';
import { ProductComponent } from './product/product.component';
import { TestComponent } from './test/test.component';
import { ProductManageComponent } from './product-manage/product-manage.component';
import { ProductManageListComponent } from './product-manage-list/product-manage-list.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { UserManageComponent } from './user-manage/user-manage.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { AdminComponent } from './admin/admin.component';
import { EditUserForCustomerComponent } from './edit-user-for-customer/edit-user-for-customer.component';
import { CartManageComponent } from './cart-manage/cart-manage.component';
import { ShowListCartComponent } from './show-list-cart/show-list-cart.component';

const routesConfig: Routes=[
  {path: '', component:ViewMainComponent},
  {path:'contact', component:ContactComponent},
  {path:'about-us', component: AboutUsComponent},
  {path:'login', component: LoginComponent},
  {path:'login-admin', component: LoginAdminComponent},
  {path:'sign-up', component: SignUpComponent},
  {path:'ssd', component: SSDComponent},
  {path:'cpu', component:CPUComponent},
  {path:'ram',component:RAMComponent},
  {path:'shopping-cart',component:ShoppingCartComponent},
  {path:'product-detail/:id',component:ProductDetailComponent},
  {path:'search-product',component:SearchProductComponent},
  {path:'search-product/:keySearch',component:SearchProductComponent},
  {path:'manage-user-for-customer/:id/edit',component:EditUserForCustomerComponent},
  {path:'view-list-cart',component:ShowListCartComponent},



  {path:'productmanage',
     children:[
       {path:'',component: ProductManageListComponent },
       {path: ':id/edit', component:ProductEditComponent},
       {path: 'add', component:ProductAddComponent}, 
     ]},
  {path:'user-manage', children:[
       {path:'',component: UserManageComponent },
       {path: ':id/edit', component:UserEditComponent},
       {path: 'add', component:SignUpComponent}, 
     ]},



  {path:'admin',component:AdminComponent,
     
     children:[
           {path:'',component: ProductManageListComponent },
           {path:'productmanage',
               children:[
                 {path:'',component: ProductManageListComponent },
                 {path: ':id/edit', component:ProductEditComponent},
                 {path: 'add', component:ProductAddComponent}, 
               ]},


            {path:'user-manage',
               children:[
                 {path:'',component: UserManageComponent },
                 {path: ':id/edit', component:UserEditComponent},
                 {path: 'add', component:SignUpComponent}, 
               ]},

            {path:'cart-manage',
               children:[
                 {path:'',component: CartManageComponent },
                 // {path: ':id/edit', component:UserEditComponent},
                 // {path: 'add', component:SignUpComponent}, 
               ]},



     ]},
 



]
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SlideComponent,
    FooterComponent,
    LienHeMessengerComponent,
    ViewMainComponent,
    ContactComponent,
    LoginComponent,
    SignUpComponent,
    SSDComponent,
    RAMComponent,
    CPUComponent,
    ProductComponent,
    TestComponent,
    ProductManageComponent,
    ProductManageListComponent,
    ProductEditComponent,
    ProductAddComponent,
    VNDONG,
    SUMMARY,
    CARTMONEY,
    AboutUsComponent,
    ProductDetailComponent,
    ShoppingCartComponent,
    LoginAdminComponent,
    UserManageComponent,
    UserEditComponent,
    SearchProductComponent,
    AdminComponent,
    EditUserForCustomerComponent,
    CartManageComponent,
    ShowListCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routesConfig,{scrollPositionRestoration: 'enabled'}),
  ],
  providers: [ProductService,
              CartService,
              SecurityService,
              ShareDateService,
              UserService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
