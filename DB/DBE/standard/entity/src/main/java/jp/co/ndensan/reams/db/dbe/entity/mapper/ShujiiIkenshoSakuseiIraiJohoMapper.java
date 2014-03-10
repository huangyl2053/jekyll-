/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 主治医意見書作成依頼情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class ShujiiIkenshoSakuseiIraiJohoMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoSakuseiIraiJohoMapper() {
    }

    /**
     * 引数のエンティティから主治医意見書作成依頼情報を作成して返します。
     *
     * @param entity 主治医意見書作成依頼情報エンティティ
     * @return 主治医意見書作成依頼情報
     */
    public static ShujiiIkenshoSakuseiIrai toShujiiIkenshoSakuseiIrai(DbT5011ShujiiIkenshoIraiJohoEntity entity) {
        return new ShujiiIkenshoSakuseiIrai(
                entity.getShinseishoKanriNo(),
                new IkenshosakuseiIraiRirekiNo(entity.getIkenshoIraiRirekiNo()),
                new KaigoIryoKikanCode(entity.getKaigoIryokikanCode()),
                new KaigoDoctorCode(entity.getKaigoIshiCode()),
                IkenshoIraiKubun.toValue(entity.getIkenshoIraiKubun()),
                entity.getIkenshoIraiKaisu(),
                IshiKubun.toValue(entity.getIshiKubunCode().value()),
                entity.getIkenshoSakuseiIraiYMD(),
                entity.getIkenshoSakuseiKigenYMD(),
                entity.getIkenshoShutsuryokuYMD(),
                entity.getSeikyushoShutsuryokuYMD(),
                SakuseiryoSeikyuKubun.toValue(entity.getSakuseiryoSeikyuKubun().value()),
                entity.getIkenshoSakuseiTokusokuYMD(),
                IkenshoSakuseiTokusokuHoho.toValue(entity.getIkenshoSakuseiTokusokuHoho()),
                entity.getIkenshoTokusokuKaisu(),
                entity.getIkenshoTokusokuMemo());
    }

    /**
     * 引数のエンティティリストから主治医意見書作成依頼情報リストを作成して返します。
     *
     * @param entityList 主治医意見書作成依頼情報エンティティリスト
     * @return 主治医意見書作成依頼情報リスト
     */
    public static List<ShujiiIkenshoSakuseiIrai> toShujiiIkenshoSakuseiIraiList(List<DbT5011ShujiiIkenshoIraiJohoEntity> entityList) {
        List<ShujiiIkenshoSakuseiIrai> list = new ArrayList<>();
        for (DbT5011ShujiiIkenshoIraiJohoEntity entity : entityList) {
            list.add(toShujiiIkenshoSakuseiIrai(entity));
        }
        return list;
    }

    /**
     * 引数の主治医意見書作成依頼情報からエンティティを作成して返します。
     *
     * @param iraiJoho 主治医意見書作成依頼情報
     * @return 主治医意見書作成依頼情報エンティティ
     */
    public static DbT5011ShujiiIkenshoIraiJohoEntity toDbT5011ShujiiIkenshoIraiJohoEntity(ShujiiIkenshoSakuseiIrai iraiJoho) {
        DbT5011ShujiiIkenshoIraiJohoEntity entity = new DbT5011ShujiiIkenshoIraiJohoEntity();
        entity.setShinseishoKanriNo(iraiJoho.get申請書管理番号());
        entity.setIkenshoIraiRirekiNo(iraiJoho.get意見書作成依頼履歴番号().value().intValue());
        entity.setKaigoIryokikanCode(iraiJoho.get介護医療機関コード().getValue());
        entity.setKaigoIshiCode(iraiJoho.get介護医師コード().value());
        entity.setIkenshoIraiKubun(iraiJoho.get意見書作成依頼区分().getCode());
        entity.setIkenshoIraiKaisu(iraiJoho.get意見書作成回数());
        entity.setIshiKubunCode(new Code(iraiJoho.get医師区分().getCode()));
        entity.setIkenshoSakuseiIraiYMD(iraiJoho.get意見書作成依頼年月日());
        entity.setIkenshoSakuseiKigenYMD(iraiJoho.get意見書作成期限年月日());
        entity.setIkenshoShutsuryokuYMD(iraiJoho.get意見書出力年月日());
        entity.setSeikyushoShutsuryokuYMD(iraiJoho.get請求書出力年月日());
        entity.setSakuseiryoSeikyuKubun(new Code(iraiJoho.get作成料請求区分().getCode()));
        entity.setIkenshoSakuseiTokusokuYMD(iraiJoho.get意見書作成督促年月日());
        entity.setIkenshoSakuseiTokusokuHoho(iraiJoho.get意見書作成督促方法().getCode());
        entity.setIkenshoTokusokuKaisu(iraiJoho.get意見書作成督促回数());
        entity.setIkenshoTokusokuMemo(iraiJoho.get意見書作成督促メモ());
        return entity;
    }
}
