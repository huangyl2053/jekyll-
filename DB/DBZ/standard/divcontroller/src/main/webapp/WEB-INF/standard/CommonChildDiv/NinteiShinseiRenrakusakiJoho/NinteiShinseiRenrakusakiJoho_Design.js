var DBZ;
(function (DBZ) {
    (function (NinteiShinseiRenrakusakiJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClilck_btnShinkiTsuika = function () {
                return "onClilck_btnShinkiTsuika";
            };

            Events.onClilck_btnFukushaTsuika = function () {
                return "onClilck_btnFukushaTsuika";
            };

            Events.onClilck_btnZenkaiFukusha = function () {
                return "onClilck_btnZenkaiFukusha";
            };

            Events.onSelect_RenrakusakiIchiran = function () {
                return "onSelect_RenrakusakiIchiran";
            };

            Events.onClick_btnShusei = function () {
                return "onClick_btnShusei";
            };

            Events.onClick_btnSakujo = function () {
                return "onClick_btnSakujo";
            };

            Events.onClick_btnToroku = function () {
                return "onClick_btnToroku";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
            return Events;
        })();
        NinteiShinseiRenrakusakiJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseiRenrakusakiJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseiRenrakusakiJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.RenrakusakiIchiran = function () {
                return new UZA.Panel(this.convFiledName("RenrakusakiIchiran"));
            };

            Controls.prototype.btnShinkiTsuika = function () {
                return new UZA.Button(this.convFiledName("btnShinkiTsuika"));
            };

            Controls.prototype.btnFukushaTsuika = function () {
                return new UZA.Button(this.convFiledName("btnFukushaTsuika"));
            };

            Controls.prototype.btnZenkaiFukusha = function () {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            };

            Controls.prototype.dgRenrakusakiIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgRenrakusakiIchiran"));
            };

            Controls.prototype.RenrakusakiNyuryoku = function () {
                return new UZA.Panel(this.convFiledName("RenrakusakiNyuryoku"));
            };

            Controls.prototype.txtRenban = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRenban"));
            };

            Controls.prototype.ddlRenrakusakiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlRenrakusakiKubun"));
            };

            Controls.prototype.ddlShisho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShisho"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtKanaShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtKanaShimei"));
            };

            Controls.prototype.ddlTsuzukigara = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTsuzukigara"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtJusho"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.btnToroku = function () {
                return new UZA.Button(this.convFiledName("btnToroku"));
            };

            Controls.prototype.txtMobileNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtMobileNo"));
            };

            Controls.prototype.txtYusenJuni = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtYusenJuni"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        NinteiShinseiRenrakusakiJoho.Controls = Controls;
    })(DBZ.NinteiShinseiRenrakusakiJoho || (DBZ.NinteiShinseiRenrakusakiJoho = {}));
    var NinteiShinseiRenrakusakiJoho = DBZ.NinteiShinseiRenrakusakiJoho;
})(DBZ || (DBZ = {}));
