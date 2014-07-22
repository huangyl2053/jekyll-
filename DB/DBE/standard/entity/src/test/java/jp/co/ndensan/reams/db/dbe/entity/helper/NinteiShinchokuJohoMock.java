/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentsToEnkitsuchiHakko;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定進捗情報を生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinchokuJohoMock {

    public static final ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("0001"));
    public static final FlexibleDate 認定申請情報登録年月日 = new FlexibleDate(new RString("20140101"));
    public static final boolean 認定延期通知発行に対する同意有無 = true;
    public static final FlexibleDate 認定延期通知発行年月日 = new FlexibleDate(new RString("20140102"));
    public static final int 認定延期通知発行回数 = 1;
    public static final RString 要介護認定延期理由 = new RString("理由");
    public static final FlexibleDate 要介護認定一次判定情報抽出年月日 = new FlexibleDate(new RString("20140103"));
    public static final FlexibleDate 依頼情報データ送信年月日 = new FlexibleDate(new RString("20140104"));
    public static final FlexibleDate 認定調査依頼完了年月日 = new FlexibleDate(new RString("20140105"));
    public static final FlexibleDate 認定調査完了年月日 = new FlexibleDate(new RString("20140106"));
    public static final FlexibleDate 主治医意見書作成依頼完了年月日 = new FlexibleDate(new RString("20140107"));
    public static final FlexibleDate 主治医意見書登録完了年月日 = new FlexibleDate(new RString("20140108"));
    public static final FlexibleDate 要介護認定一次判定完了年月日 = new FlexibleDate(new RString("20140109"));
    public static final FlexibleDate 要介護認定1_5次判定完了年月日 = new FlexibleDate(new RString("20140110"));
    public static final FlexibleDate 認定審査会割当完了年月日 = new FlexibleDate(new RString("20140111"));
    public static final FlexibleDate 認定審査会完了年月日 = new FlexibleDate(new RString("20140112"));
    public static final FlexibleDate センター送信年月日 = new FlexibleDate(new RString("20140113"));

    /**
     * テスト用認定進捗情報Entityを返します。
     *
     * @return 認定進捗情報Entity
     */
    public static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity() {
        DbT5005NinteiShinchokuJohoEntity entity = new DbT5005NinteiShinchokuJohoEntity();

        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setNinteiShinseiJohoTorokuYMD(認定申請情報登録年月日);
        entity.setEnkitsuchiDoiUmuKubun(認定延期通知発行に対する同意有無);
        entity.setEnkitsuchiHakkoYMD(認定延期通知発行年月日);
        entity.setEnkitsuchiHakkoKaisu(認定延期通知発行回数);
        entity.setNinteiEnkiRuyu(要介護認定延期理由);
        entity.setIchijihanteiChushutsuYMD(要介護認定一次判定情報抽出年月日);
        entity.setIraiJohoSoshinYMD(依頼情報データ送信年月日);
        entity.setNinteichosaIraiKanryoYMD(認定調査依頼完了年月日);
        entity.setNinteichosaKanryoYMD(認定調査完了年月日);
        entity.setIkenshoSakuseiIraiKanryoYMD(主治医意見書作成依頼完了年月日);
        entity.setIkenshoTorokuKanryoYMD(主治医意見書登録完了年月日);
        entity.setIchijiHanteiKanryoYMD(要介護認定一次判定完了年月日);
        entity.setIchiGoHanteiKanryoYMD(要介護認定1_5次判定完了年月日);
        entity.setNinteiShinsakaiWariateKanryoYMD(認定審査会割当完了年月日);
        entity.setNinteiShinsakaiKanryoYMD(認定審査会完了年月日);
        entity.setCenterSoshinYMD(センター送信年月日);

        return entity;
    }

    /**
     * テスト用認定進捗情報を返します。
     *
     * @return 認定進捗情報
     */
    public static YokaigoNinteiProgress create認定進捗情報() {
        return new YokaigoNinteiProgress(
                申請書管理番号,
                認定申請情報登録年月日,
                ConsentsToEnkitsuchiHakko.toValue(認定延期通知発行に対する同意有無),
                認定延期通知発行年月日,
                認定延期通知発行回数,
                要介護認定延期理由,
                要介護認定一次判定情報抽出年月日,
                依頼情報データ送信年月日,
                認定調査依頼完了年月日,
                認定調査完了年月日,
                主治医意見書作成依頼完了年月日,
                主治医意見書登録完了年月日,
                要介護認定一次判定完了年月日,
                要介護認定1_5次判定完了年月日,
                認定審査会割当完了年月日,
                認定審査会完了年月日,
                センター送信年月日);
    }
}
