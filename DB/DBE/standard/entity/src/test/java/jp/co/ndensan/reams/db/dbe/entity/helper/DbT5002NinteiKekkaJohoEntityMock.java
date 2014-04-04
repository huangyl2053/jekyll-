/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiKekkaIdoJiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * DbT5002NinteiKekkaJohoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT5002NinteiKekkaJohoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5002NinteiKekkaJohoEntityMock() {
    }

    /**
     * DbT5002NinteiKekkaJohoEntityを生成して返します。
     *
     * @return DbT5002NinteiKekkaJohoEntity
     */
    public static DbT5002NinteiKekkaJohoEntity getSpiedInstance() {
        return spy(getDbT5002NinteiKekkaJohoEntity());
    }

    /**
     * DbT5002NinteiKekkaJohoEntityを生成して返します。
     *
     * @return DbT5002NinteiKekkaJohoEntity
     */
    public static DbT5002NinteiKekkaJohoEntity getDbT5002NinteiKekkaJohoEntity() {
        DbT5002NinteiKekkaJohoEntity entity = new DbT5002NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(new RString("1234567890"));
        entity.setShoKisaiHokenshaNo(new RString("123456"));
        entity.setHihokenshaNo(new RString("123456"));
        entity.setYoukaigodoNinteiYMD(FlexibleDate.MIN);
        entity.setYoukaigoJotaiKubunCode(new Code("コード"));
        entity.setNinteiYukoKikan(1);
        entity.setNinteiYukoKaishiYMD(FlexibleDate.MIN);
        entity.setNinteiYukoShuryoYMD(FlexibleDate.MAX);
        entity.setTokuteiShippeiCode(new Code("コード"));
        entity.setShisetsuNyushoFlag(true);
        entity.setShinsakaiKaisaiNo(123);
        entity.setShinsakaiIken(new RString("審査会意見"));
        entity.setIchijiHnateiKekkaHenkoRiyu(new RString("一次判定結果変更理由"));
        entity.setYokaigoJotaizoReiCode(new Code("コード"));
        entity.setNinteishinsakaiIkenShurui(ShinsakaiIkenShurui.サービス利用への意見.getCode());
        entity.setKaigoServiceShurui(KaigoServiceShurui.訪問介護.getCode());
        entity.setNinteiKekkaIdoJiyu(NinteiKekkaIdoJiyu.職権追加.getCode());
        entity.setNinteiKekkaIdoYMD(FlexibleDate.MIN);
        entity.setNinteiTorikeshiRiyu(new RString("認定取消理由"));
        entity.setNinteiTorikeshiYMD(FlexibleDate.MAX);
        entity.setTuchiKubun(new RString("01"));
        entity.setNinteiRiyu(new RString("認定理由"));
        entity.setShinsakaiMemo(new RString("審査会メモ"));
        return entity;
    }
}
