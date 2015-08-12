/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定送信済みマスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5190NinteiSoshinzumiMasterEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_同一連番 = 1;
    public static final boolean DEFAULT_引き渡しフラグ = false;
    public static final YMDHM DEFAULT_引き渡し日時 = new YMDHM("201401011234");
    public static final YMDHM DEFAULT_引き渡し解除日時 = new YMDHM("201401011234");
    public static final int DEFAULT_引き渡しカウント = 1;
    public static final YMDHM DEFAULT_取り込み日時 = new YMDHM("201401011234");
    public static final RString DEFAULT_再送付区分 = new RString("名称");
    public static final RString DEFAULT_再調査送付区分 = new RString("名称");
    public static final RString DEFAULT_再意見書送付区分 = new RString("名称");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5190NinteiSoshinzumiMasterEntityGenerator() {
    }

    public static DbT5190NinteiSoshinzumiMasterEntity createDbT5190NinteiSoshinzumiMasterEntity() {
        DbT5190NinteiSoshinzumiMasterEntity entity = new DbT5190NinteiSoshinzumiMasterEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setDoitsuRemban(DEFAULT_同一連番);
        entity.setIsHikiwatashi(DEFAULT_引き渡しフラグ);
        entity.setHikiwatashiYMDHM(DEFAULT_引き渡し日時);
        entity.setHikiwatashiKaijoYMDHM(DEFAULT_引き渡し解除日時);
        entity.setHikiwatashiCount(DEFAULT_引き渡しカウント);
        entity.setTorikomiYMDHM(DEFAULT_取り込み日時);
        entity.setSaiSofuKubun(DEFAULT_再送付区分);
        entity.setSaiChosaSofuKubun(DEFAULT_再調査送付区分);
        entity.setSaiIkenshoSofuKubun(DEFAULT_再意見書送付区分);
        return entity;
    }
}
