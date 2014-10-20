/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.config;

import jp.co.ndensan.reams.db.dbz.business.config.HokenshaInfoConfig;
import jp.co.ndensan.reams.db.dbz.business.hokensha.IIntroducedHokensha;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.ur.urz.business.IAssociation;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;
import jp.co.ndensan.reams.ur.urz.realservice.AssociationService;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 *
 * @author N3327 三浦 凌
 */
public class IntroducedHokenshaLoader {

    private final IIntroducedHokensha hokensha;

    public IntroducedHokenshaLoader() {
        this.hokensha = new _IntroducedHokensha();
    }

    /**
     * 業務Configから、導入保険者情報を取得して返します。
     *
     * @return 導入保険者情報
     */
    public IIntroducedHokensha load() {
        return this.hokensha;
    }

    private static class _IntroducedHokensha implements IIntroducedHokensha {

        private final HokenshaInfoConfig config;
        private final IAssociation association;

        private _IntroducedHokensha() {
            this.config = new HokenshaInfoConfig();
            this.association = AssociationService.createAssociationFinder().getAssociation();
        }

        @Override
        public HokenshaName get保険者名称() {
            return this.config.get保険者名称();
        }

        @Override
        public boolean is広域保険者() {
            return false;
        }

        @Override
        public ShoKisaiHokenshaNo get証記載保険者番号() {
            return this.config.get証記載保険者番号();
        }

        @Override
        public AtenaJusho get住所() {
            return this.config.get保険者住所();
        }

        @Override
        public YubinNo get郵便番号() {
            return this.config.get郵便番号();
        }

        @Override
        public TelNo get電話番号() {
            return this.config.get電話番号();
        }

        @Override
        public GunNamePrint get群名表示有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public TodofukenNamePrint get都道府県名表示有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ShichosonNamePrint get市町村名表示有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public KatagakiPrint get方書表示有無() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public JushoEditPattern get住所編集方法() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
