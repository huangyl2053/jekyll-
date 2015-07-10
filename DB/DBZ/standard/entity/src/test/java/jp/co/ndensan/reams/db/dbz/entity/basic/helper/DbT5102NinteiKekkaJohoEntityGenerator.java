/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8223 朴義一
 */
public final class DbT5102NinteiKekkaJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("00000000000000002");
    public static final FlexibleDate DEFAULT_二次判定年月日 = new FlexibleDate("20150604");
    public static final Code DEFAULT_二次判定要介護状態区分コード = new Code("21");
    public static final Integer DEFAULT_二次判定認定有効期間 = 1;
    public static final FlexibleDate DEFAULT_二次判定認定有効開始年月日 = new FlexibleDate("20150604");
    public static final FlexibleDate DEFAULT_二次判定認定有効終了年月日 = new FlexibleDate("20150605");
    public static final Integer DEFAULT_介護認定審査会開催番号 = 1;
    public static final RString DEFAULT_介護認定審査会意見 = new RString("介護認定審査会意見");
    public static final RString DEFAULT_一次判定結果変更理由 = new RString("一次判定結果変更理由");
    public static final Code DEFAULT_要介護状態像例コード = new Code("99");
    public static final RString DEFAULT_認定審査会意見種類 = new RString("1");
    public static final RString DEFAULT_審査会メモ = new RString("審査会メモ");
    public static final Code DEFAULT_二次判定結果入力方法 = new Code("1");
    public static final FlexibleDate DEFAULT_二次判定結果入力年月日 = new FlexibleDate("20150604");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5102NinteiKekkaJohoEntityGenerator() {
    }

    public static DbT5102NinteiKekkaJohoEntity createDbT5102NinteiKekkaJohoEntity() {
        DbT5102NinteiKekkaJohoEntity entity = new DbT5102NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNijiHanteiYMD(DEFAULT_二次判定年月日);
        entity.setNijiHanteiYokaigoJotaiKubunCode(DEFAULT_二次判定要介護状態区分コード);
        entity.setNijiHanteiNinteiYukoKikan(DEFAULT_二次判定認定有効期間);
        entity.setNijiHanteiNinteiYukoKaishiYMD(DEFAULT_二次判定認定有効開始年月日);
        entity.setNijiHanteiNinteiYukoShuryoYMD(DEFAULT_二次判定認定有効終了年月日);
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setShinsakaiIken(DEFAULT_介護認定審査会意見);
        entity.setIchijiHnateiKekkaHenkoRiyu(DEFAULT_一次判定結果変更理由);
        entity.setYokaigoJotaizoReiCode(DEFAULT_要介護状態像例コード);
        entity.setNinteishinsakaiIkenShurui(DEFAULT_認定審査会意見種類);
        entity.setShinsakaiMemo(DEFAULT_審査会メモ);
        entity.setNijiHanteiKekkaInputHoho(DEFAULT_二次判定結果入力方法);
        entity.setNiniHanteiKekkaInputYMD(DEFAULT_二次判定結果入力年月日);
        return entity;
    }
}
