var DBZ;
(function (DBZ) {
    (function (JogaiShinsainJoho) {
        var Events = (function () {
            function Events() {
            }
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
        JogaiShinsainJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JogaiShinsainJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JogaiShinsainJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JogaiShinsainJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JogaiShinsainJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ShinsakaiIinIchiran = function () {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinIchiran"));
            };

            Controls.prototype.btnShinkiTsuika = function () {
                return new UZA.Button(this.convFiledName("btnShinkiTsuika"));
            };

            Controls.prototype.dgShinsakaiIinIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinIchiran"));
            };

            Controls.prototype.ShinsakaiIinJoho = function () {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinJoho"));
            };

            Controls.prototype.txtShinsakaiIinCode = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinCode"));
            };

            Controls.prototype.btnShinsakaiIinGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShinsakaiIinGuide"));
            };

            Controls.prototype.txtShinsakaiIinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinName"));
            };

            Controls.prototype.dgShozokuKikanIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShozokuKikanIchiran"));
            };

            Controls.prototype.lblShozokuKikan = function () {
                return new UZA.Label(this.convFiledName("lblShozokuKikan"));
            };

            Controls.prototype.btnToroku = function () {
                return new UZA.Button(this.convFiledName("btnToroku"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        JogaiShinsainJoho.Controls = Controls;
    })(DBZ.JogaiShinsainJoho || (DBZ.JogaiShinsainJoho = {}));
    var JogaiShinsainJoho = DBZ.JogaiShinsainJoho;
})(DBZ || (DBZ = {}));
