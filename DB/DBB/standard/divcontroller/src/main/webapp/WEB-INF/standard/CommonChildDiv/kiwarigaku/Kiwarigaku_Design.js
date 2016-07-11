var DBB;
(function (DBB) {
    (function (Kiwarigaku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        Kiwarigaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "Kiwarigaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.Kiwarigaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblTsuki1 = function () {
                return new UZA.TablePanel(this.convFiledName("tblTsuki1"));
            };

            Controls.prototype.celTsuki0 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki0"));
            };

            Controls.prototype.lblTsuki0 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki0"));
            };

            Controls.prototype.celTsuki = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki"));
            };

            Controls.prototype.lblTsuki = function () {
                return new UZA.Label(this.convFiledName("lblTsuki"));
            };

            Controls.prototype.celTsuki1 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki1"));
            };

            Controls.prototype.lblTsuki1 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki1"));
            };

            Controls.prototype.celTsuki2 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki2"));
            };

            Controls.prototype.lblTsuki2 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki2"));
            };

            Controls.prototype.celTsuki3 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki3"));
            };

            Controls.prototype.lblTsuki3 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki3"));
            };

            Controls.prototype.celTsuki4 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki4"));
            };

            Controls.prototype.lblTsuki4 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki4"));
            };

            Controls.prototype.celTsuki5 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki5"));
            };

            Controls.prototype.lblTsuki5 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki5"));
            };

            Controls.prototype.celTsuki6 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki6"));
            };

            Controls.prototype.lblTsuki6 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki6"));
            };

            Controls.prototype.celTsuki7 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki7"));
            };

            Controls.prototype.lblTsuki7 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki7"));
            };

            Controls.prototype.celTsuki8 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki8"));
            };

            Controls.prototype.lblTsuki8 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki8"));
            };

            Controls.prototype.celTsuki9 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki9"));
            };

            Controls.prototype.lblTsuki9 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki9"));
            };

            Controls.prototype.celTsuki10 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki10"));
            };

            Controls.prototype.lblTsuki10 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki10"));
            };

            Controls.prototype.celTsuki11 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki11"));
            };

            Controls.prototype.lblTsuki11 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki11"));
            };

            Controls.prototype.celTsuki12 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki12"));
            };

            Controls.prototype.lblTsuki12 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki12"));
            };

            Controls.prototype.tblKiwariGaku1 = function () {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku1"));
            };

            Controls.prototype.celTokucho = function () {
                return new UZA.TableCell(this.convFiledName("celTokucho"));
            };

            Controls.prototype.lblTokucho = function () {
                return new UZA.Label(this.convFiledName("lblTokucho"));
            };

            Controls.prototype.celFucho = function () {
                return new UZA.TableCell(this.convFiledName("celFucho"));
            };

            Controls.prototype.lblFucho = function () {
                return new UZA.Label(this.convFiledName("lblFucho"));
            };

            Controls.prototype.celTokuchoKi = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi"));
            };

            Controls.prototype.lblTokuchoKi = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi"));
            };

            Controls.prototype.celTokuchoKibetsuGaku = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku"));
            };

            Controls.prototype.lblTokuKibetsuGaku = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku"));
            };

            Controls.prototype.celTokuchoNofuGaku = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku"));
            };

            Controls.prototype.lblTokuNofuGaku = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku"));
            };

            Controls.prototype.celFuchoKi = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi"));
            };

            Controls.prototype.lblFuchoKi = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi"));
            };

            Controls.prototype.celFuchoKibetsuGaku = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku"));
            };

            Controls.prototype.lblFuchoKibetsuGaku = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku"));
            };

            Controls.prototype.celFuchoNofuGaku = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku"));
            };

            Controls.prototype.lblFuchoNofuGaku = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku"));
            };

            Controls.prototype.celTokuchoKi1 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi1"));
            };

            Controls.prototype.lblTokuchoKi1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi1"));
            };

            Controls.prototype.celTokuchoKibetsuGaku1 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku1"));
            };

            Controls.prototype.lblTokuKibetsuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku1"));
            };

            Controls.prototype.celTokuchoNofuGaku1 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku1"));
            };

            Controls.prototype.lblTokuNofuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku1"));
            };

            Controls.prototype.celFuchoKi1 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi1"));
            };

            Controls.prototype.lblFuchoKi1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi1"));
            };

            Controls.prototype.celFuchoKibetsuGaku1 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku1"));
            };

            Controls.prototype.lblFuchoKibetsuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku1"));
            };

            Controls.prototype.celFuchoNofuGaku1 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku1"));
            };

            Controls.prototype.lblFuchoNofuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku1"));
            };

            Controls.prototype.celTokuchoKi2 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi2"));
            };

            Controls.prototype.lblTokuchoKi2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi2"));
            };

            Controls.prototype.celTokuchoKibetsuGaku2 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku2"));
            };

            Controls.prototype.lblTokuKibetsuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku2"));
            };

            Controls.prototype.celTokuchoNofuGaku2 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku2"));
            };

            Controls.prototype.lblTokuNofuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku2"));
            };

            Controls.prototype.celFuchoKi2 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi2"));
            };

            Controls.prototype.lblFuchoKi2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi2"));
            };

            Controls.prototype.celFuchoKibetsuGaku2 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku2"));
            };

            Controls.prototype.lblFuchoKibetsuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku2"));
            };

            Controls.prototype.celFuchoNofuGaku2 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku2"));
            };

            Controls.prototype.lblFuchoNofuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku2"));
            };

            Controls.prototype.celTokuchoKi3 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi3"));
            };

            Controls.prototype.lblTokuchoKi3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi3"));
            };

            Controls.prototype.celTokuchoKibetsuGaku3 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku3"));
            };

            Controls.prototype.lblTokuKibetsuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku3"));
            };

            Controls.prototype.celTokuchoNofuGaku3 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku3"));
            };

            Controls.prototype.lblTokuNofuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku3"));
            };

            Controls.prototype.celFuchoKi3 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi3"));
            };

            Controls.prototype.lblFuchoKi3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi3"));
            };

            Controls.prototype.celFuchoKibetsuGaku3 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku3"));
            };

            Controls.prototype.lblFuchoKibetsuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku3"));
            };

            Controls.prototype.celFuchoNofuGaku3 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku3"));
            };

            Controls.prototype.lblFuchoNofuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku3"));
            };

            Controls.prototype.celTokuchoKi4 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi4"));
            };

            Controls.prototype.lblTokuchoKi4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi4"));
            };

            Controls.prototype.celTokuchoKibetsuGaku4 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku4"));
            };

            Controls.prototype.lblTokuKibetsuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku4"));
            };

            Controls.prototype.celTokuchoNofuGaku4 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku4"));
            };

            Controls.prototype.lblTokuNofuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku4"));
            };

            Controls.prototype.celFuchoKi4 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi4"));
            };

            Controls.prototype.lblFuchoKi4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi4"));
            };

            Controls.prototype.celFuchoKibetsuGaku4 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku4"));
            };

            Controls.prototype.lblFuchoKibetsuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku4"));
            };

            Controls.prototype.celFuchoNofuGaku4 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku4"));
            };

            Controls.prototype.lblFuchoNofuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku4"));
            };

            Controls.prototype.celTokuchoKi5 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi5"));
            };

            Controls.prototype.lblTokuchoKi5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi5"));
            };

            Controls.prototype.celTokuchoKibetsuGaku5 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku5"));
            };

            Controls.prototype.lblTokuKibetsuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku5"));
            };

            Controls.prototype.celTokuchoNofuGaku5 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku5"));
            };

            Controls.prototype.lblTokuNofuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku5"));
            };

            Controls.prototype.celFuchoKi5 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi5"));
            };

            Controls.prototype.lblFuchoKi5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi5"));
            };

            Controls.prototype.celFuchoKibetsuGaku5 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku5"));
            };

            Controls.prototype.lblFuchoKibetsuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku5"));
            };

            Controls.prototype.celFuchoNofuGaku5 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku5"));
            };

            Controls.prototype.lblFuchoNofuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku5"));
            };

            Controls.prototype.celTokuchoKi6 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi6"));
            };

            Controls.prototype.lblTokuchoKi6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi6"));
            };

            Controls.prototype.celTokuchoKibetsuGaku6 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku6"));
            };

            Controls.prototype.lblTokuKibetsuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku6"));
            };

            Controls.prototype.celTokuchoNofuGaku6 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku6"));
            };

            Controls.prototype.lblTokuNofuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku6"));
            };

            Controls.prototype.celFuchoKi6 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi6"));
            };

            Controls.prototype.lblFuchoKi6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi6"));
            };

            Controls.prototype.celFuchoKibetsuGaku6 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku6"));
            };

            Controls.prototype.lblFuchoKibetsuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku6"));
            };

            Controls.prototype.celFuchoNofuGaku6 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku6"));
            };

            Controls.prototype.lblFuchoNofuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku6"));
            };

            Controls.prototype.celTokuchoKi7 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi7"));
            };

            Controls.prototype.lblTokuchoKi7 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi7"));
            };

            Controls.prototype.celTokuchoKibetsuGaku7 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku7"));
            };

            Controls.prototype.lblTokuKibetsuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku7"));
            };

            Controls.prototype.celTokuchoNofuGaku7 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku7"));
            };

            Controls.prototype.lblTokuNofuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku7"));
            };

            Controls.prototype.celFuchoKi7 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi7"));
            };

            Controls.prototype.lblFuchoKi7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi7"));
            };

            Controls.prototype.celFuchoKibetsuGaku7 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku7"));
            };

            Controls.prototype.lblFuchoKibetsuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku7"));
            };

            Controls.prototype.celFuchoNofuGaku7 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku7"));
            };

            Controls.prototype.lblFuchoNofuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku7"));
            };

            Controls.prototype.celTokuchoKi8 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi8"));
            };

            Controls.prototype.lblTokuchoKi8 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi8"));
            };

            Controls.prototype.celTokuchoKibetsuGaku8 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku8"));
            };

            Controls.prototype.lblTokuKibetsuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku8"));
            };

            Controls.prototype.celTokuchoNofuGaku8 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku8"));
            };

            Controls.prototype.lblTokuNofuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku8"));
            };

            Controls.prototype.celFuchoKi8 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi8"));
            };

            Controls.prototype.lblFuchoKi8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi8"));
            };

            Controls.prototype.celFuchoKibetsuGaku8 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku8"));
            };

            Controls.prototype.lblFuchoKibetsuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku8"));
            };

            Controls.prototype.celFuchoNofuGaku8 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku8"));
            };

            Controls.prototype.lblFuchoNofuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku8"));
            };

            Controls.prototype.celTokuchoKi9 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi9"));
            };

            Controls.prototype.lblTokuchoKi9 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi9"));
            };

            Controls.prototype.celTokuchoKibetsuGaku9 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku9"));
            };

            Controls.prototype.lblTokuKibetsuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku9"));
            };

            Controls.prototype.celTokuchoNofuGaku9 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku9"));
            };

            Controls.prototype.lblTokuNofuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku9"));
            };

            Controls.prototype.celFuchoKi9 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi9"));
            };

            Controls.prototype.lblFuchoKi9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi9"));
            };

            Controls.prototype.celFuchoKibetsuGaku9 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku9"));
            };

            Controls.prototype.lblFuchoKibetsuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku9"));
            };

            Controls.prototype.celFuchoNofuGaku9 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku9"));
            };

            Controls.prototype.lblFuchoNofuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku9"));
            };

            Controls.prototype.celTokuchoKi10 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi10"));
            };

            Controls.prototype.lblTokuchoKi10 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi10"));
            };

            Controls.prototype.celTokuchoKibetsuGaku10 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku10"));
            };

            Controls.prototype.lblTokuKibetsuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku10"));
            };

            Controls.prototype.celTokuchoNofuGaku10 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku10"));
            };

            Controls.prototype.lblTokuNofuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku10"));
            };

            Controls.prototype.celFuchoKi10 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi10"));
            };

            Controls.prototype.lblFuchoKi10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi10"));
            };

            Controls.prototype.celFuchoKibetsuGaku10 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku10"));
            };

            Controls.prototype.lblFuchoKibetsuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku10"));
            };

            Controls.prototype.celFuchoNofuGaku10 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku10"));
            };

            Controls.prototype.lblFuchoNofuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku10"));
            };

            Controls.prototype.celTokuchoKi11 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi11"));
            };

            Controls.prototype.lblTokuchoKi11 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi11"));
            };

            Controls.prototype.celTokuchoKibetsuGaku11 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku11"));
            };

            Controls.prototype.lblTokuKibetsuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku11"));
            };

            Controls.prototype.celTokuchoNofuGaku11 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku11"));
            };

            Controls.prototype.lblTokuNofuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku11"));
            };

            Controls.prototype.celFuchoKi11 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi11"));
            };

            Controls.prototype.lblFuchoKi11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi11"));
            };

            Controls.prototype.celFuchoKibetsuGaku11 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku11"));
            };

            Controls.prototype.lblFuchoKibetsuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku11"));
            };

            Controls.prototype.celFuchoNofuGaku11 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku11"));
            };

            Controls.prototype.lblFuchoNofuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku11"));
            };

            Controls.prototype.celTokuchoKi12 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi12"));
            };

            Controls.prototype.lblTokuchoKi12 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi12"));
            };

            Controls.prototype.celTokuchoKibetsuGaku12 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku12"));
            };

            Controls.prototype.lblTokuKibetsuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku12"));
            };

            Controls.prototype.celTokuchoNofuGaku12 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku12"));
            };

            Controls.prototype.lblTokuNofuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku12"));
            };

            Controls.prototype.celFuchoKi12 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi12"));
            };

            Controls.prototype.lblFuchoKi12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi12"));
            };

            Controls.prototype.celFuchoKibetsuGaku12 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku12"));
            };

            Controls.prototype.lblFuchoKibetsuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku12"));
            };

            Controls.prototype.celFuchoNofuGaku12 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku12"));
            };

            Controls.prototype.lblFuchoNofuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku12"));
            };

            Controls.prototype.tblTsuki2 = function () {
                return new UZA.TablePanel(this.convFiledName("tblTsuki2"));
            };

            Controls.prototype.celTsuki13 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki13"));
            };

            Controls.prototype.lblTsuki13 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki13"));
            };

            Controls.prototype.tblKiwariGaku2 = function () {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku2"));
            };

            Controls.prototype.celTokuchoKi13 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi13"));
            };

            Controls.prototype.lblTokuchoKi13 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi13"));
            };

            Controls.prototype.celTokuchoKibetsuGaku13 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku13"));
            };

            Controls.prototype.lblTokuKibetsuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku13"));
            };

            Controls.prototype.celTokuchoNofuGaku13 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku13"));
            };

            Controls.prototype.lblTokuNofuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku13"));
            };

            Controls.prototype.celFuchoKi13 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi13"));
            };

            Controls.prototype.lblFuchoKi13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi13"));
            };

            Controls.prototype.celFuchoKibetsuGaku13 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku13"));
            };

            Controls.prototype.lblFuchoKibetsuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku13"));
            };

            Controls.prototype.celFuchoNofuGaku13 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku13"));
            };

            Controls.prototype.lblFuchoNofuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku13"));
            };

            Controls.prototype.tblTsuki3 = function () {
                return new UZA.TablePanel(this.convFiledName("tblTsuki3"));
            };

            Controls.prototype.celTsuki14 = function () {
                return new UZA.TableCell(this.convFiledName("celTsuki14"));
            };

            Controls.prototype.lblTsuki14 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki14"));
            };

            Controls.prototype.tblKiwariGaku3 = function () {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku3"));
            };

            Controls.prototype.celTokuchoKi14 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi14"));
            };

            Controls.prototype.lblTokuchoKi14 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi14"));
            };

            Controls.prototype.celTokuchoKibetsuGaku14 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku14"));
            };

            Controls.prototype.lblTokuKibetsuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku14"));
            };

            Controls.prototype.celTokuchoNofuGaku14 = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku14"));
            };

            Controls.prototype.lblTokuNofuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku14"));
            };

            Controls.prototype.celFuchoKi14 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKi14"));
            };

            Controls.prototype.lblFuchoKi14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi14"));
            };

            Controls.prototype.celFuchoKibetsuGaku14 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku14"));
            };

            Controls.prototype.lblFuchoKibetsuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku14"));
            };

            Controls.prototype.celFuchoNofuGaku14 = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku14"));
            };

            Controls.prototype.lblFuchoNofuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku14"));
            };

            Controls.prototype.tblTsuki4 = function () {
                return new UZA.TablePanel(this.convFiledName("tblTsuki4"));
            };

            Controls.prototype.celTsukiGokei = function () {
                return new UZA.TableCell(this.convFiledName("celTsukiGokei"));
            };

            Controls.prototype.lblTsukiGokei = function () {
                return new UZA.Label(this.convFiledName("lblTsukiGokei"));
            };

            Controls.prototype.tblKiwariGaku4 = function () {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku4"));
            };

            Controls.prototype.celTokuchoKiGokei = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKiGokei"));
            };

            Controls.prototype.lblTokuchoKiGokei = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKiGokei"));
            };

            Controls.prototype.celTokuchoKibetsuGakuGokei = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGakuGokei"));
            };

            Controls.prototype.lblTokuKibetsuGakuGokei = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGakuGokei"));
            };

            Controls.prototype.celTokuchoNofuGakuGokei = function () {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGakuGokei"));
            };

            Controls.prototype.lblTokuNofuGakuGokei = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGakuGokei"));
            };

            Controls.prototype.celFuchoKiGokei = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKiGokei"));
            };

            Controls.prototype.lblFuchoKiGokei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKiGokei"));
            };

            Controls.prototype.celFuchoKibetsuGakuGokei = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGakuGokei"));
            };

            Controls.prototype.lblFuchoKibetsuGakuGokei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGakuGokei"));
            };

            Controls.prototype.celFuchoNofuGakuGokei = function () {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGakuGokei"));
            };

            Controls.prototype.lblFuchoNofuGakuGokei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGakuGokei"));
            };
            return Controls;
        })();
        Kiwarigaku.Controls = Controls;
    })(DBB.Kiwarigaku || (DBB.Kiwarigaku = {}));
    var Kiwarigaku = DBB.Kiwarigaku;
})(DBB || (DBB = {}));
