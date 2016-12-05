var DBZ;
(function (DBZ) {
    (function (ShinsakaiJohoKojin) {
        var Events = (function () {
            function Events() {
            }
            Events.btn_Modoru = function () {
                return "btn_Modoru";
            };
            return Events;
        })();
        ShinsakaiJohoKojin.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinsakaiJohoKojin";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShinsakaiJohoKojin.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShinsakaiJohoKojin.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinsakaiJohoKojin = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinsakaiNo = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiNo"));
            };

            Controls.prototype.txtGogitaiName = function () {
                return new UZA.TextBox(this.convFiledName("txtGogitaiName"));
            };

            Controls.prototype.txtShinsakaijoMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaijoMeisho"));
            };

            Controls.prototype.txtShinsakaijoChikuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaijoChikuCode"));
            };

            Controls.prototype.txtShinsakaijoChikuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaijoChikuMeisho"));
            };

            Controls.prototype.txtShinsaKaishiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinsaKaishiDay"));
            };

            Controls.prototype.txtShinsaKaishiTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShinsaKaishiTime"));
            };

            Controls.prototype.txtShinsaShuryoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShinsaShuryoTime"));
            };

            Controls.prototype.txtShinsaTime = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsaTime"));
            };

            Controls.prototype.ShussekiIinJoho = function () {
                return new UZA.Panel(this.convFiledName("ShussekiIinJoho"));
            };

            Controls.prototype.lblShinsakaiIin = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiIin"));
            };

            Controls.prototype.lblHoketsuShinsakaiIin = function () {
                return new UZA.Label(this.convFiledName("lblHoketsuShinsakaiIin"));
            };

            Controls.prototype.dgShinsakaiIin = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIin"));
            };

            Controls.prototype.dgHoketsuShinsakai = function () {
                return new UZA.DataGrid(this.convFiledName("dgHoketsuShinsakai"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        ShinsakaiJohoKojin.Controls = Controls;
    })(DBZ.ShinsakaiJohoKojin || (DBZ.ShinsakaiJohoKojin = {}));
    var ShinsakaiJohoKojin = DBZ.ShinsakaiJohoKojin;
})(DBZ || (DBZ = {}));
