/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護支援専門員エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7064CareManegerEntityGenerator {

    public static final RString DEFAULT_介護支援専門員番号 = new RString("Data");
    public static final AtenaMeisho DEFAULT_介護支援専門員名 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_介護支援専門員名カナ = new AtenaKanaMeisho("");
    public static final JigyoshaNo DEFAULT_所属事業者番号 = new JigyoshaNo("0123400001");
    public static final FlexibleDate DEFAULT_有効開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_有効終了年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7064CareManegerEntityGenerator() {
    }

    public static DbT7064CareManegerEntity createDbT7064CareManegerEntity() {
        DbT7064CareManegerEntity entity = new DbT7064CareManegerEntity();
        entity.setKaigoShienSenmoninNo(DEFAULT_介護支援専門員番号);
        entity.setKaigoShienSenmoninMei(DEFAULT_介護支援専門員名);
        entity.setKaigoShienSenmoninMeiKana(DEFAULT_介護支援専門員名カナ);
        entity.setShozokuJigyoshaNo(DEFAULT_所属事業者番号);
        entity.setYukoKaishiDate(DEFAULT_有効開始年月日);
        entity.setYukoShuryoDate(DEFAULT_有効終了年月日);
        return entity;
    }
}
