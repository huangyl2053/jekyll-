/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * DbT5011ShujiiIkenshoIraiJohoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT5011ShujiiIkenshoIraiJohoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5011ShujiiIkenshoIraiJohoEntityMock() {
    }

    /**
     * DbT5011ShujiiIkenshoIraiJohoEntityを生成して返します。
     *
     * @return DbT5011ShujiiIkenshoIraiJohoEntity
     */
    public static DbT5011ShujiiIkenshoIraiJohoEntity getSpiedInstance() {
        DbT5011ShujiiIkenshoIraiJohoEntity entity = new DbT5011ShujiiIkenshoIraiJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("申請書管理番号")));
        entity.setIkenshoIraiRirekiNo(0);
        entity.setShujiiIryoKikanCode(new RString("主治医医療機関コード"));
        entity.setIshiShikibetsuNo(new RString("医師識別番号"));
        entity.setIkenshoIraiKubun(new RString("1"));
        entity.setIkenshoIraiKaisu(1);
        entity.setIshiKubunCode(new Code(new RString("2")));
        entity.setIkenshoSakuseiIraiYMD(FlexibleDate.MIN);
        entity.setIkenshoSakuseiKigenYMD(FlexibleDate.MAX);
        entity.setIkenshoShutsuryokuYMD(FlexibleDate.MIN);
        entity.setSeikyushoShutsuryokuYMD(FlexibleDate.MAX);
        entity.setSakuseiryoSeikyuKubun(new Code(new RString("12")));
        entity.setIkenshoSakuseiTokusokuYMD(FlexibleDate.MIN);
        entity.setIkenshoSakuseiTokusokuHoho(new RString("3"));
        entity.setIkenshoTokusokuKaisu(2);
        entity.setIkenshoTokusokuMemo(new RString("意見書作成督促メモ"));
        return spy(entity);
    }
}
