/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link DaisanshaKoiKyusho}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiKyushoBuilder {

    private final DbT3082DaisanshaKoiKyushoEntity entity;
    private final DaisanshaKoiKyushoIdentifier id;

    /**
     * {@link DbT3082DaisanshaKoiKyushoEntity}より{@link DaisanshaKoiKyusho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3082DaisanshaKoiKyushoEntity}
     * @param id {@link DaisanshaKoiKyushoIdentifier}
     *
     */
    DaisanshaKoiKyushoBuilder(
            DbT3082DaisanshaKoiKyushoEntity entity,
            DaisanshaKoiKyushoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * 第三者行為求償請求番号を設定します。
     *
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set第三者行為求償請求番号(RString 第三者行為求償請求番号) {
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        entity.setKyushoSeikyuNo(第三者行為求償請求番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 給付額合計を設定します。
     *
     * @param 給付額合計 給付額合計
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set給付額合計(Decimal 給付額合計) {
        requireNonNull(給付額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額合計"));
        entity.setKyufuGakuGokei(給付額合計);
        return this;
    }

    /**
     * 過失相殺額を設定します。
     *
     * @param 過失相殺額 過失相殺額
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set過失相殺額(Decimal 過失相殺額) {
        requireNonNull(過失相殺額, UrSystemErrorMessages.値がnull.getReplacedMessage("過失相殺額"));
        entity.setKashitsuSosatsuGaku(過失相殺額);
        return this;
    }

    /**
     * 保険給付請求額を設定します。
     *
     * @param 保険給付請求額 保険給付請求額
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set保険給付請求額(Decimal 保険給付請求額) {
        requireNonNull(保険給付請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付請求額"));
        entity.setHokenKyufuSeikyuGaku(保険給付請求額);
        return this;
    }

    /**
     * 損害賠償金納入期限を設定します。
     *
     * @param 損害賠償金納入期限 損害賠償金納入期限
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set損害賠償金納入期限(FlexibleDate 損害賠償金納入期限) {
        requireNonNull(損害賠償金納入期限, UrSystemErrorMessages.値がnull.getReplacedMessage("損害賠償金納入期限"));
        entity.setSongaiBaishoKinNonyuYMD(損害賠償金納入期限);
        return this;
    }

    /**
     * 請求先郵便番号を設定します。
     *
     * @param 請求先郵便番号 請求先郵便番号
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set請求先郵便番号(YubinNo 請求先郵便番号) {
        requireNonNull(請求先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先郵便番号"));
        entity.setSeikyusakiYubinNo(請求先郵便番号);
        return this;
    }

    /**
     * 請求先住所を設定します。
     *
     * @param 請求先住所 請求先住所
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set請求先住所(RString 請求先住所) {
        requireNonNull(請求先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先住所"));
        entity.setSeikyusakiJusho(請求先住所);
        return this;
    }

    /**
     * 請求先名称を設定します。
     *
     * @param 請求先名称 請求先名称
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set請求先名称(AtenaMeisho 請求先名称) {
        requireNonNull(請求先名称, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先名称"));
        entity.setSeikyusakiMeisho(請求先名称);
        return this;
    }

    /**
     * 請求先部署を設定します。
     *
     * @param 請求先部署 請求先部署
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set請求先部署(RString 請求先部署) {
        requireNonNull(請求先部署, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先部署"));
        entity.setSeikyusakiBusho(請求先部署);
        return this;
    }

    /**
     * 請求先担当者を設定します。
     *
     * @param 請求先担当者 請求先担当者
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set請求先担当者(AtenaMeisho 請求先担当者) {
        requireNonNull(請求先担当者, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先担当者"));
        entity.setSeikyusakiTantosha(請求先担当者);
        return this;
    }

    /**
     * 請求先電話番号を設定します。
     *
     * @param 請求先電話番号 請求先電話番号
     * @return {@link DaisanshaKoiKyushoBuilder}
     */
    public DaisanshaKoiKyushoBuilder set請求先電話番号(TelNo 請求先電話番号) {
        requireNonNull(請求先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先電話番号"));
        entity.setSeikyusakiTelNo(請求先電話番号);
        return this;
    }

    /**
     * {@link DaisanshaKoiKyusho}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiKyusho}のインスタンス
     */
    public DaisanshaKoiKyusho build() {
        return new DaisanshaKoiKyusho(entity, id);
    }
}
