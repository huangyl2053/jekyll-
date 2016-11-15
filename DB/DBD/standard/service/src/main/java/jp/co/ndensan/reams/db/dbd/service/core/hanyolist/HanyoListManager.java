/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.hanyolist;

import jp.co.ndensan.reams.db.dbz.business.core.hanyolist.HanyoListShutsuryokuKomoku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.KingakuEditingNecessity;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 汎用リスト出力(利用者負担額減免)_帳票出力編集クラスです．
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
public class HanyoListManager {

    private static final int NO_3 = 3;
    private static final int NO_6 = 6;

    /**
     * HanyoListManagerのインスタンス化
     *
     * @return HanyoListManager
     */
    public static HanyoListManager createInstance() {
        return InstanceProvider.create(HanyoListManager.class);
    }

    /**
     * 帳票出力編集
     *
     * @param i i
     * @param hanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku
     * @param 項目内容new 項目内容new
     * @return 項目内容new
     */
    public RString 項目内容new編集(int i, RString 項目内容new, HanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku) {
        if (hanyoListShutsuryokuKomoku != null && hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get出力項目日付区分() != null) {
            if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get出力項目日付区分().value().code().equals(new RString("02"))) {
                項目内容new = new FlexibleDate(項目内容new.replace("/", "").toString()).wareki()
                        .firstYear(FirstYear.ICHI_NEN).toDateString().substring(0, NO_3);
            } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get出力項目日付区分().value().code().equals(new RString("03"))) {
                項目内容new = new FlexibleDate(項目内容new.replace("/", "").toString()).wareki().
                        firstYear(FirstYear.ICHI_NEN).toDateString().substring(0, NO_6);
            } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get出力項目日付区分().value().code().equals(new RString("04"))) {
                項目内容new = new FlexibleDate(項目内容new.replace("/", "").toString()).wareki()
                        .toDateString().substring(0, NO_6);
            }
        }
        if (hanyoListShutsuryokuKomoku != null && hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get金額編集().equals(KingakuEditingNecessity.必要.getコード())) {
            項目内容new = DecimalFormatter.toコンマ区切りRString(new Decimal(項目内容new.toString()), 0);
        }
        return 項目内容new;
    }

    /**
     * 宛名抽出条件編集
     *
     * @param atenacyusyutsujyoken atenacyusyutsujyoken
     * @param key key
     *
     */
    public void 地区区分編集(AtenaSelectBatchParameter atenacyusyutsujyoken, ShikibetsuTaishoPSMSearchKeyBuilder key) {
        set町域コード(atenacyusyutsujyoken, key);
        set行政区コード(atenacyusyutsujyoken, key);
        set地区コード1(atenacyusyutsujyoken, key);
        set地区コード2(atenacyusyutsujyoken, key);
        set地区コード3(atenacyusyutsujyoken, key);
    }

    /**
     * get地方公共団体
     *
     * @param 市町村コード 市町村コード
     * @return get地方公共団体 get地方公共団体
     *
     */
    public Association get地方公共団体(LasdecCode 市町村コード) {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        return finder.getAssociation(市町村コード);
    }

    private void set町域コード(AtenaSelectBatchParameter atenacyusyutsujyoken, ShikibetsuTaishoPSMSearchKeyBuilder key) {
        if (atenacyusyutsujyoken.getJusho_From() != null) {
            key.set町域コード開始値(new ChoikiCode(atenacyusyutsujyoken.getJusho_From()));
        }
        if (atenacyusyutsujyoken.getJusho_To() != null) {
            key.set町域コード終了値(new ChoikiCode(atenacyusyutsujyoken.getJusho_To()));
        }
    }

    private void set行政区コード(AtenaSelectBatchParameter atenacyusyutsujyoken, ShikibetsuTaishoPSMSearchKeyBuilder key) {
        if (atenacyusyutsujyoken.getGyoseiku_From() != null) {
            key.set行政区コード開始値(new GyoseikuCode(atenacyusyutsujyoken.getGyoseiku_From()));
        }
        if (atenacyusyutsujyoken.getGyoseiku_To() != null) {
            key.set行政区コード終了値(new GyoseikuCode(atenacyusyutsujyoken.getGyoseiku_To()));
        }
    }

    private void set地区コード1(AtenaSelectBatchParameter atenacyusyutsujyoken, ShikibetsuTaishoPSMSearchKeyBuilder key) {
        if (atenacyusyutsujyoken.getChiku1_From() != null) {
            key.set地区コード1開始値(new ChikuCode(atenacyusyutsujyoken.getChiku1_From()));
        }
        if (atenacyusyutsujyoken.getChiku1_To() != null) {
            key.set地区コード1終了値(new ChikuCode(atenacyusyutsujyoken.getChiku1_To()));
        }

    }

    private void set地区コード2(AtenaSelectBatchParameter atenacyusyutsujyoken, ShikibetsuTaishoPSMSearchKeyBuilder key) {
        if (atenacyusyutsujyoken.getChiku2_From() != null) {
            key.set地区コード2開始値(new ChikuCode(atenacyusyutsujyoken.getChiku2_From()));
        }
        if (atenacyusyutsujyoken.getChiku2_To() != null) {
            key.set地区コード2終了値(new ChikuCode(atenacyusyutsujyoken.getChiku2_To()));
        }
    }

    private void set地区コード3(AtenaSelectBatchParameter atenacyusyutsujyoken, ShikibetsuTaishoPSMSearchKeyBuilder key) {
        if (atenacyusyutsujyoken.getChiku2_From() != null) {
            key.set地区コード3開始値(new ChikuCode(atenacyusyutsujyoken.getChiku2_From()));
        }
        if (atenacyusyutsujyoken.getChiku3_To() != null) {
            key.set地区コード3終了値(new ChikuCode(atenacyusyutsujyoken.getChiku3_To()));
        }
    }
}
