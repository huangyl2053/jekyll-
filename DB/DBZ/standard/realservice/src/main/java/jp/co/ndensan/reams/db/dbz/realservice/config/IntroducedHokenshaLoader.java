/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.config;

import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.business.hokensha.IIntroducedHokensha;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 *
 * @author N3327 三浦 凌
 */
public class IntroducedHokenshaLoader {

    public IntroducedHokenshaLoader() {
    }

    /**
     * 業務Configから、導入保険者情報を取得して返します。
     *
     * @return 導入保険者情報
     */
    public IIntroducedHokensha load() {
        return new _IntroducedHokensha();
    }

    private static final class _IntroducedHokensha implements IIntroducedHokensha {

        private final HokenshaJohoConfig hokenshaJoho;

        private _IntroducedHokensha() {
            this.hokenshaJoho = new HokenshaJohoConfig();
        }

        @Override
        public HokenshaName get保険者名称() {
            return this.hokenshaJoho.get保険者名称();
        }

        @Override
        public boolean is広域保険者() {
            return false;
        }

        @Override
        public ShoKisaiHokenshaNo get証記載保険者番号() {
            return this.hokenshaJoho.get証記載保険者番号();
        }

        @Override
        public AtenaJusho get住所() {
            return this.hokenshaJoho.get保険者住所();
        }

        @Override
        public YubinNo get郵便番号() {
            return this.hokenshaJoho.get郵便番号();
        }

        @Override
        public TelNo get電話番号() {
            return this.hokenshaJoho.get電話番号();
        }

        @Override
        public GunNamePrint get群名印字有無() {
            return this.get群名印字有無();
        }

        @Override
        public TodofukenNamePrint get都道府名印字有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ShichosonNamePrint get市町村名印字有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public KatagakiPrint get方書印字有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public HowToEditJusho get印字住所編集方法() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
