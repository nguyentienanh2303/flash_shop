import {ProductCart} from './../models/product-cart';

export class Cart{
	public id: number;
	public userId: number;
	public status: number;
	public firstName: string;
	public lastName: string;
	public adress: string;
	public createData: string;
	public modifiedData: string;
	public phone: string;
	public listCartProduct: ProductCart[];
}