/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.chosaitakusakiandchosaininput.ChosaItakusakiAndChosain;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 調査委託先＆調査員入力のクラスです。
 *
 * @reamsid_L DBZ-1300-030 zhangguopeng
 */
public class ChosaItakusakiAndChosainInputFinder {

    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5121ShinseiRirekiJohoDac dbT5121Dac;
    private final DbT5910NinteichosaItakusakiJohoDac dbT5910Dac;
    private final DbT5913ChosainJohoDac dbT5913Dac;

    /**
     * コンストラクタです。
     */
    public ChosaItakusakiAndChosainInputFinder() {
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        this.dbT5910Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.dbT5913Dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT5101Dac {@link DbT5101NinteiShinseiJohoDac}
     * @param dbT5121Dac {@link DbT5121ShinseiRirekiJohoDac}
     * @param dbT5910Dac {@link DbT5910NinteichosaItakusakiJohoDac}
     * @param dbT5913Dac {@link DbT5913ChosainJohoDac}
     */
    ChosaItakusakiAndChosainInputFinder(DbT5101NinteiShinseiJohoDac dbT5101Dac, DbT5121ShinseiRirekiJohoDac dbT5121Dac,
            DbT5910NinteichosaItakusakiJohoDac dbT5910Dac, DbT5913ChosainJohoDac dbT5913Dac) {
        this.dbT5101Dac = dbT5101Dac;
        this.dbT5121Dac = dbT5121Dac;
        this.dbT5910Dac = dbT5910Dac;
        this.dbT5913Dac = dbT5913Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaItakusakiAndChosainInputFinder}のインスタンスを返します。
     *
     * @return ChosaItakusakiAndChosainInputFinder
     */
    public static ChosaItakusakiAndChosainInputFinder createInstance() {
        return InstanceProvider.create(ChosaItakusakiAndChosainInputFinder.class);
    }

    /**
     * 認定調査委託先コードtxtのロストフォーカス時の検索します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return NinteichosaItakusakiJoho 認定調査委託先情報を管理するクラス
     */
    @Transaction
    public NinteichosaItakusakiJoho onBlurTxtChosaItakusakiCode(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        DbT5910NinteichosaItakusakiJohoEntity dbT5910Entity = dbT5910Dac.selectByKey(市町村コード, 認定調査委託先コード);
        if (dbT5910Entity != null && dbT5910Entity.getJokyoFlag()) {
            return new NinteichosaItakusakiJoho(dbT5910Entity);
        }
        return null;
    }

    /**
     * 認定調査員コードtxtのロストフォーカス時の検索します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return ShinsakaiChosainJoho 調査員情報のビジネスクラス
     */
    @Transaction
    public ShinsakaiChosainJoho onBlurTxtChosainCode(LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        DbT5913ChosainJohoEntity dbT5913Entity = dbT5913Dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード);
        if (dbT5913Entity != null && dbT5913Entity.getJokyoFlag()) {
            return new ShinsakaiChosainJoho(dbT5913Entity);
        }
        return null;
    }

    /**
     * 前回を複写する際の検索します。
     *
     * @param 申請管理番号 申請管理番号
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return ChosaItakusakiAndChosain　調査委託先＆調査員入力ビジネスクラス
     */
    @Transaction
    public ChosaItakusakiAndChosain onClickBtnZenkaiFukusha(ShinseishoKanriNo 申請管理番号, LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        ChosaItakusakiAndChosain chosaItakusakiAndChosain = new ChosaItakusakiAndChosain();
        DbT5121ShinseiRirekiJohoEntity dbT5121Entity = dbT5121Dac.selectByKey(申請管理番号);
        if (dbT5121Entity != null) {
            DbT5101NinteiShinseiJohoEntity dbT5101Entity = dbT5101Dac.selectByKey(dbT5121Entity.getZenkaiShinseishoKanriNo());
            if (dbT5101Entity != null) {
                認定調査委託先コード = dbT5101Entity.getNinteiChosaItakusakiCode();
                認定調査員コード = dbT5101Entity.getNinteiChosainCode();
                NinteichosaItakusakiJoho ninteichosaItakusakiJoho
                        = onBlurTxtChosaItakusakiCode(市町村コード, 認定調査委託先コード.getColumnValue());
                chosaItakusakiAndChosain.set事業者名称(ninteichosaItakusakiJoho == null ? RString.EMPTY : ninteichosaItakusakiJoho.get事業者名称());

                ShinsakaiChosainJoho shinsakaiChosainJoho = onBlurTxtChosainCode(市町村コード, 認定調査委託先コード, 認定調査員コード);
                chosaItakusakiAndChosain.set調査員氏名(shinsakaiChosainJoho == null ? RString.EMPTY : shinsakaiChosainJoho.get調査員氏名());
            }
        }
        chosaItakusakiAndChosain.set認定調査委託先コード(認定調査委託先コード.getColumnValue());
        chosaItakusakiAndChosain.set認定調査員コード(認定調査員コード.getColumnValue());
        return chosaItakusakiAndChosain;
    }

}
