var DBZ;
(function (DBZ) {
    (function (ChosaTokkiShiryoShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radGenpoMask = function () {
                return "onChange_radGenpoMask";
            };
            return Events;
        })();
        ChosaTokkiShiryoShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaTokkiShiryoShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosaTokkiShiryoShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaTokkiShiryoShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaTokkiShiryoShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radGenpoMask = function () {
                return new UZA.RadioButton(this.convFiledName("radGenpoMask"));
            };

            Controls.prototype.genpoTabContainer = function () {
                return new UZA.TabContainer(this.convFiledName("genpoTabContainer"));
            };

            Controls.prototype.genpoTabPanel1 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel1"));
            };

            Controls.prototype.imgGenpo1 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo1"));
            };

            Controls.prototype.genpoTabPanel2 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel2"));
            };

            Controls.prototype.imgGenpo2 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo2"));
            };

            Controls.prototype.genpoTabPanel3 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel3"));
            };

            Controls.prototype.imgGenpo3 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo3"));
            };

            Controls.prototype.genpoTabPanel4 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel4"));
            };

            Controls.prototype.imgGenpo4 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo4"));
            };

            Controls.prototype.genpoTabPanel5 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel5"));
            };

            Controls.prototype.imgGenpo5 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo5"));
            };

            Controls.prototype.genpoTabPanel6 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel6"));
            };

            Controls.prototype.imgGenpo6 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo6"));
            };

            Controls.prototype.genpoTabPanel7 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel7"));
            };

            Controls.prototype.imgGenpo7 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo7"));
            };

            Controls.prototype.genpoTabPanel8 = function () {
                return new UZA.TabPanel(this.convFiledName("genpoTabPanel8"));
            };

            Controls.prototype.imgGenpo8 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo8"));
            };

            Controls.prototype.maskTabContainer = function () {
                return new UZA.TabContainer(this.convFiledName("maskTabContainer"));
            };

            Controls.prototype.maskTabPanel1 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel1"));
            };

            Controls.prototype.imgMask1 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask1"));
            };

            Controls.prototype.maskTabPanel2 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel2"));
            };

            Controls.prototype.imgMask2 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask2"));
            };

            Controls.prototype.maskTabPanel3 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel3"));
            };

            Controls.prototype.imgMask3 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask3"));
            };

            Controls.prototype.maskTabPanel4 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel4"));
            };

            Controls.prototype.imgMask4 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask4"));
            };

            Controls.prototype.maskTabPanel5 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel5"));
            };

            Controls.prototype.imgMask5 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask5"));
            };

            Controls.prototype.maskTabPanel6 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel6"));
            };

            Controls.prototype.imgMask6 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask6"));
            };

            Controls.prototype.maskTabPanel7 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel7"));
            };

            Controls.prototype.imgMask7 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask7"));
            };

            Controls.prototype.maskTabPanel8 = function () {
                return new UZA.TabPanel(this.convFiledName("maskTabPanel8"));
            };

            Controls.prototype.imgMask8 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask8"));
            };
            return Controls;
        })();
        ChosaTokkiShiryoShokai.Controls = Controls;
    })(DBZ.ChosaTokkiShiryoShokai || (DBZ.ChosaTokkiShiryoShokai = {}));
    var ChosaTokkiShiryoShokai = DBZ.ChosaTokkiShiryoShokai;
})(DBZ || (DBZ = {}));
