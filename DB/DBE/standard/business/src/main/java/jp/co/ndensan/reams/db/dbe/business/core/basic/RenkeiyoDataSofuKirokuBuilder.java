/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RenkeiyoDataSofuKiroku}の編集を行うビルダークラスです。
 */
public class RenkeiyoDataSofuKirokuBuilder {

    private final DbT5191RenkeiyoDataSofuKirokuEntity entity;
    private final RenkeiyoDataSofuKirokuIdentifier id;

    /**
     * {@link DbT5191RenkeiyoDataSofuKirokuEntity}より{@link RenkeiyoDataSofuKiroku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5191RenkeiyoDataSofuKirokuEntity}
     * @param id {@link RenkeiyoDataSofuKirokuIdentifier}
     *
     */
    RenkeiyoDataSofuKirokuBuilder(
            DbT5191RenkeiyoDataSofuKirokuEntity entity,
            RenkeiyoDataSofuKirokuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 資料作成日を設定します。
     *
     * @param 資料作成日 資料作成日
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set資料作成日(FlexibleDate 資料作成日) {
        requireNonNull(資料作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("資料作成日"));
        entity.setShiryoSakuseiYMD(資料作成日);
        return this;
    }

    /**
     * 引渡し区分を設定します。
     *
     * @param 引渡し区分 引渡し区分
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set引渡し区分(RString 引渡し区分) {
        requireNonNull(引渡し区分, UrSystemErrorMessages.値がnull.getReplacedMessage("引渡し区分"));
        entity.setHikiwatashiKubun(引渡し区分);
        return this;
    }

    /**
     * 引渡日時を設定します。
     *
     * @param 引渡日時 引渡日時
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set引渡日時(YMDHMS 引渡日時) {
        requireNonNull(引渡日時, UrSystemErrorMessages.値がnull.getReplacedMessage("引渡日時"));
        entity.setHikiwatashiTimeStamp(引渡日時);
        return this;
    }

    /**
     * 再送付区分を設定します。
     *
     * @param 再送付区分 再送付区分
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set再送付区分(RString 再送付区分) {
        requireNonNull(再送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再送付区分"));
        entity.setSaiSoufuKubun(再送付区分);
        return this;
    }

    /**
     * 再調査送付区分を設定します。
     *
     * @param 再調査送付区分 再調査送付区分
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set再調査送付区分(RString 再調査送付区分) {
        requireNonNull(再調査送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再調査送付区分"));
        entity.setSaiChousaSofuKubun(再調査送付区分);
        return this;
    }

    /**
     * 再意見書送付区分を設定します。
     *
     * @param 再意見書送付区分 再意見書送付区分
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set再意見書送付区分(RString 再意見書送付区分) {
        requireNonNull(再意見書送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再意見書送付区分"));
        entity.setSaiIkenshoSofuKubun(再意見書送付区分);
        return this;
    }

    /**
     * 再イメージ送付区分を設定します。
     *
     * @param 再イメージ送付区分 再イメージ送付区分
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set再イメージ送付区分(RString 再イメージ送付区分) {
        requireNonNull(再イメージ送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再イメージ送付区分"));
        entity.setSaiImageSofuKubun(再イメージ送付区分);
        return this;
    }

    /**
     * 再送信年月日を設定します。
     *
     * @param 再送信年月日 再送信年月日
     * @return {@link RenkeiyoDataSofuKirokuBuilder}
     */
    public RenkeiyoDataSofuKirokuBuilder set再送信年月日(FlexibleDate 再送信年月日) {
        requireNonNull(再送信年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("再送信年月日"));
        entity.setSaiSoshinYMD(再送信年月日);
        return this;
    }

    /**
     * {@link RenkeiyoDataSofuKiroku}のインスタンスを生成します。
     *
     * @return {@link RenkeiyoDataSofuKiroku}のインスタンス
     */
    public RenkeiyoDataSofuKiroku build() {
        return new RenkeiyoDataSofuKiroku(entity, id);
    }
}
