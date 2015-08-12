/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定一次判定結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT4116IchijiHanteiKekkaJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final boolean DEFAULT_仮一次判定区分 = false;
    public static final FlexibleDate DEFAULT_要介護認定一次判定年月日 = new FlexibleDate("20141030");
    public static final Code DEFAULT_要介護認定一次判定結果コード = new Code("01");
    public static final Code DEFAULT_要介護認定一次判定結果コード_認知症加算 = new Code("01");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4116IchijiHanteiKekkaJohoEntityGenerator() {
    }

    public static DbT4116IchijiHanteiKekkaJohoEntity createDbT4116IchijiHanteiKekkaJohoEntity() {
        DbT4116IchijiHanteiKekkaJohoEntity entity = new DbT4116IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setKariIchijiHanteiKubun(DEFAULT_仮一次判定区分);
        entity.setIchijiHanteiYMD(DEFAULT_要介護認定一次判定年月日);
        entity.setIchijiHanteiKekkaCode(DEFAULT_要介護認定一次判定結果コード);
        entity.setIchijiHanteiKekkaNinchishoKasanCode(DEFAULT_要介護認定一次判定結果コード_認知症加算);
        return entity;
    }
}
