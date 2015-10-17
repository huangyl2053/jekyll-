/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChohyoSeigyoKyotsuControl}の編集を行うビルダークラスです。
 */
public class ChohyoSeigyoKyotsuControlBuilder {

    private final DbT7066ChohyoSeigyoKyotsuControlEntity entity;
    private final ChohyoSeigyoKyotsuControlIdentifier id;

    /**
     * {@link DbT7066ChohyoSeigyoKyotsuControlEntity}より{@link ChohyoSeigyoKyotsuControl}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7066ChohyoSeigyoKyotsuControlEntity}
     * @param id {@link ChohyoSeigyoKyotsuControlIdentifier}
     *
     */
    ChohyoSeigyoKyotsuControlBuilder(
            DbT7066ChohyoSeigyoKyotsuControlEntity entity,
            ChohyoSeigyoKyotsuControlIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サブ業務コードを設定します。
     *
     * @param サブ業務コード サブ業務コード
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 帳票分類IDを設定します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set帳票分類ID(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        entity.setChohyoBunruiID(帳票分類ID);
        return this;
    }

    /**
     * 共通画面使用有無を設定します。
     *
     * @param 共通画面使用有無 共通画面使用有無
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set共通画面使用有無(boolean 共通画面使用有無) {
        requireNonNull(共通画面使用有無, UrSystemErrorMessages.値がnull.getReplacedMessage("共通画面使用有無"));
        entity.setKyotsuGamenShiyoUmu(共通画面使用有無);
        return this;
    }

    /**
     * 文書番号使用区分を設定します。
     *
     * @param 文書番号使用区分 文書番号使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set文書番号使用区分(RString 文書番号使用区分) {
        requireNonNull(文書番号使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("文書番号使用区分"));
        entity.setBunshoNoShiyoKubun(文書番号使用区分);
        return this;
    }

    /**
     * 通知書定型文使用区分を設定します。
     *
     * @param 通知書定型文使用区分 通知書定型文使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set通知書定型文使用区分(RString 通知書定型文使用区分) {
        requireNonNull(通知書定型文使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書定型文使用区分"));
        entity.setTsuchishoTeikeibunShiyoKubun(通知書定型文使用区分);
        return this;
    }

    /**
     * 認証者使用区分を設定します。
     *
     * @param 認証者使用区分 認証者使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set認証者使用区分(RString 認証者使用区分) {
        requireNonNull(認証者使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("認証者使用区分"));
        entity.setNinshoshaShiyoKubun(認証者使用区分);
        return this;
    }

    /**
     * 帳票出力順使用区分を設定します。
     *
     * @param 帳票出力順使用区分 帳票出力順使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set帳票出力順使用区分(RString 帳票出力順使用区分) {
        requireNonNull(帳票出力順使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票出力順使用区分"));
        entity.setChohyoShuturyokujunShiyoKubun(帳票出力順使用区分);
        return this;
    }

    /**
     * 帳票出力順表示方法を設定します。
     *
     * @param 帳票出力順表示方法 帳票出力順表示方法
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set帳票出力順表示方法(RString 帳票出力順表示方法) {
        requireNonNull(帳票出力順表示方法, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票出力順表示方法"));
        entity.setChohyoShuturyokujunHyojiHohho(帳票出力順表示方法);
        return this;
    }

    /**
     * 介護問合せ先使用区分を設定します。
     *
     * @param 介護問合せ先使用区分 介護問合せ先使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set介護問合せ先使用区分(RString 介護問合せ先使用区分) {
        requireNonNull(介護問合せ先使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護問合せ先使用区分"));
        entity.setKaigoToiawasesakiShiyoKubun(介護問合せ先使用区分);
        return this;
    }

    /**
     * 住所編集使用区分を設定します。
     *
     * @param 住所編集使用区分 住所編集使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set住所編集使用区分(RString 住所編集使用区分) {
        requireNonNull(住所編集使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集使用区分"));
        entity.setJushoHenshuShiyoKubun(住所編集使用区分);
        return this;
    }

    /**
     * 世帯主表示使用区分を設定します。
     *
     * @param 世帯主表示使用区分 世帯主表示使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set世帯主表示使用区分(RString 世帯主表示使用区分) {
        requireNonNull(世帯主表示使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯主表示使用区分"));
        entity.setSetainushiHyojiShiyoKubun(世帯主表示使用区分);
        return this;
    }

    /**
     * カスタマバーコード使用区分を設定します。
     *
     * @param カスタマバーコード使用区分 カスタマバーコード使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder setカスタマバーコード使用区分(RString カスタマバーコード使用区分) {
        requireNonNull(カスタマバーコード使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("カスタマバーコード使用区分"));
        entity.setCustomerBarCodeShiyoKubun(カスタマバーコード使用区分);
        return this;
    }

    /**
     * 外部帳票文字切れ制御使用区分を設定します。
     *
     * @param 外部帳票文字切れ制御使用区分 外部帳票文字切れ制御使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set外部帳票文字切れ制御使用区分(RString 外部帳票文字切れ制御使用区分) {
        requireNonNull(外部帳票文字切れ制御使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外部帳票文字切れ制御使用区分"));
        entity.setGaibuChohyoMojigireSeigyoShiyoKubun(外部帳票文字切れ制御使用区分);
        return this;
    }

    /**
     * 内部帳票文字切れ制御使用区分を設定します。
     *
     * @param 内部帳票文字切れ制御使用区分 内部帳票文字切れ制御使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set内部帳票文字切れ制御使用区分(RString 内部帳票文字切れ制御使用区分) {
        requireNonNull(内部帳票文字切れ制御使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票文字切れ制御使用区分"));
        entity.setNaibuChohyoMojigireSeigyoShiyoKubun(内部帳票文字切れ制御使用区分);
        return this;
    }

    /**
     * 文字切れ分離制御使用区分を設定します。
     *
     * @param 文字切れ分離制御使用区分 文字切れ分離制御使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set文字切れ分離制御使用区分(RString 文字切れ分離制御使用区分) {
        requireNonNull(文字切れ分離制御使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("文字切れ分離制御使用区分"));
        entity.setMojigireBunriSeigyoShiyoKubun(文字切れ分離制御使用区分);
        return this;
    }

    /**
     * 定型文文字サイズ使用区分を設定します。
     *
     * @param 定型文文字サイズ使用区分 定型文文字サイズ使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set定型文文字サイズ使用区分(RString 定型文文字サイズ使用区分) {
        requireNonNull(定型文文字サイズ使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("定型文文字サイズ使用区分"));
        entity.setTeikeibunMojiSizeShiyoKubun(定型文文字サイズ使用区分);
        return this;
    }

    /**
     * 口座マスク使用区分を設定します。
     *
     * @param 口座マスク使用区分 口座マスク使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set口座マスク使用区分(RString 口座マスク使用区分) {
        requireNonNull(口座マスク使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座マスク使用区分"));
        entity.setKozaMaskShiyoKubun(口座マスク使用区分);
        return this;
    }

    /**
     * 口座名義人カナ優先使用区分を設定します。
     *
     * @param 口座名義人カナ優先使用区分 口座名義人カナ優先使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set口座名義人カナ優先使用区分(RString 口座名義人カナ優先使用区分) {
        requireNonNull(口座名義人カナ優先使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人カナ優先使用区分"));
        entity.setKozaMeigininKanaYusenShiyoKubun(口座名義人カナ優先使用区分);
        return this;
    }

    /**
     * 代行プリント使用区分を設定します。
     *
     * @param 代行プリント使用区分 代行プリント使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set代行プリント使用区分(RString 代行プリント使用区分) {
        requireNonNull(代行プリント使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("代行プリント使用区分"));
        entity.setDaikoPrintShiyoKubun(代行プリント使用区分);
        return this;
    }

    /**
     * 地区表示使用区分を設定します。
     *
     * @param 地区表示使用区分 地区表示使用区分
     * @return {@link ChohyoSeigyoKyotsuControlBuilder}
     */
    public ChohyoSeigyoKyotsuControlBuilder set地区表示使用区分(RString 地区表示使用区分) {
        requireNonNull(地区表示使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("地区表示使用区分"));
        entity.setChikuhyojiShiyoKubun(地区表示使用区分);
        return this;
    }

    /**
     * {@link ChohyoSeigyoKyotsuControl}のインスタンスを生成します。
     *
     * @return {@link ChohyoSeigyoKyotsuControl}のインスタンス
     */
    public ChohyoSeigyoKyotsuControl build() {
        return new ChohyoSeigyoKyotsuControl(entity, id);
    }
}
