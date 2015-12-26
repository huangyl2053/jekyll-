/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChohyoSeigyoKyotsu}の編集を行うビルダークラスです。
 */
public class ChohyoSeigyoKyotsuBuilder {

    private final DbT7065ChohyoSeigyoKyotsuEntity entity;
    private final ChohyoSeigyoKyotsuIdentifier id;

    /**
     * {@link DbT7065ChohyoSeigyoKyotsuEntity}より{@link ChohyoSeigyoKyotsu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7065ChohyoSeigyoKyotsuEntity}
     * @param id {@link ChohyoSeigyoKyotsuIdentifier}
     *
     */
    ChohyoSeigyoKyotsuBuilder(
            DbT7065ChohyoSeigyoKyotsuEntity entity,
            ChohyoSeigyoKyotsuIdentifier id
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
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 帳票分類IDを設定します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set帳票分類ID(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        entity.setChohyoBunruiID(帳票分類ID);
        return this;
    }

    /**
     * 帳票分類名称を設定します。
     *
     * @param 帳票分類名称 帳票分類名称
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set帳票分類名称(RString 帳票分類名称) {
        requireNonNull(帳票分類名称, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類名称"));
        entity.setChohyoBunruiMeisho(帳票分類名称);
        return this;
    }

    /**
     * 住所編集区分を設定します。
     *
     * @param 住所編集区分 住所編集区分
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set住所編集区分(RString 住所編集区分) {
        requireNonNull(住所編集区分, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集区分"));
        entity.setJushoHenshuKubun(住所編集区分);
        return this;
    }

    /**
     * 住所編集都道府県名表示有無を設定します。
     *
     * @param 住所編集都道府県名表示有無 住所編集都道府県名表示有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set住所編集都道府県名表示有無(boolean 住所編集都道府県名表示有無) {
        requireNonNull(住所編集都道府県名表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集都道府県名表示有無"));
        entity.setJushoHenshuTodoufukenMeiHyojiUmu(住所編集都道府県名表示有無);
        return this;
    }

    /**
     * 住所編集郡名表示有無を設定します。
     *
     * @param 住所編集郡名表示有無 住所編集郡名表示有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set住所編集郡名表示有無(boolean 住所編集郡名表示有無) {
        requireNonNull(住所編集郡名表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集郡名表示有無"));
        entity.setJushoHenshuGunMeiHyojiUmu(住所編集郡名表示有無);
        return this;
    }

    /**
     * 住所編集市町村名表示有無を設定します。
     *
     * @param 住所編集市町村名表示有無 住所編集市町村名表示有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set住所編集市町村名表示有無(boolean 住所編集市町村名表示有無) {
        requireNonNull(住所編集市町村名表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集市町村名表示有無"));
        entity.setJushoHenshuShichosonMeiHyojiUmu(住所編集市町村名表示有無);
        return this;
    }

    /**
     * 住所編集町域編集方法を設定します。
     *
     * @param 住所編集町域編集方法 住所編集町域編集方法
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set住所編集町域編集方法(RString 住所編集町域編集方法) {
        requireNonNull(住所編集町域編集方法, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集町域編集方法"));
        entity.setJushoHenshuChoikiHenshuHoho(住所編集町域編集方法);
        return this;
    }

    /**
     * 住所編集方書表示有無を設定します。
     *
     * @param 住所編集方書表示有無 住所編集方書表示有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set住所編集方書表示有無(boolean 住所編集方書表示有無) {
        requireNonNull(住所編集方書表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("住所編集方書表示有無"));
        entity.setJushoHenshuKatagakiHyojiUmu(住所編集方書表示有無);
        return this;
    }

    /**
     * 世帯主表示有無を設定します。
     *
     * @param 世帯主表示有無 世帯主表示有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set世帯主表示有無(boolean 世帯主表示有無) {
        requireNonNull(世帯主表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯主表示有無"));
        entity.setSetainushiHyojiUmu(世帯主表示有無);
        return this;
    }

    /**
     * カスタマバーコード使用有無を設定します。
     *
     * @param カスタマバーコード使用有無 カスタマバーコード使用有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder setカスタマバーコード使用有無(boolean カスタマバーコード使用有無) {
        requireNonNull(カスタマバーコード使用有無, UrSystemErrorMessages.値がnull.getReplacedMessage("カスタマバーコード使用有無"));
        entity.setCustomerBarCodeShiyoUmu(カスタマバーコード使用有無);
        return this;
    }

    /**
     * カスタマバーコード変換エラー編集方法を設定します。
     *
     * @param カスタマバーコード変換エラー編集方法 カスタマバーコード変換エラー編集方法
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder setカスタマバーコード変換エラー編集方法(RString カスタマバーコード変換エラー編集方法) {
        requireNonNull(カスタマバーコード変換エラー編集方法, UrSystemErrorMessages.値がnull.getReplacedMessage("カスタマバーコード変換エラー編集方法"));
        entity.setCustomerBarCodeHenkanErrHenshuHoho(カスタマバーコード変換エラー編集方法);
        return this;
    }

    /**
     * 外部帳票文字切れ制御を設定します。
     *
     * @param 外部帳票文字切れ制御 外部帳票文字切れ制御
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set外部帳票文字切れ制御(RString 外部帳票文字切れ制御) {
        requireNonNull(外部帳票文字切れ制御, UrSystemErrorMessages.値がnull.getReplacedMessage("外部帳票文字切れ制御"));
        entity.setGaibuChohyoMojigireSeigyo(外部帳票文字切れ制御);
        return this;
    }

    /**
     * 内部帳票文字切れ制御を設定します。
     *
     * @param 内部帳票文字切れ制御 内部帳票文字切れ制御
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set内部帳票文字切れ制御(RString 内部帳票文字切れ制御) {
        requireNonNull(内部帳票文字切れ制御, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票文字切れ制御"));
        entity.setNaibuChohyoMojigireSeigyo(内部帳票文字切れ制御);
        return this;
    }

    /**
     * 文字切れ分離制御を設定します。
     *
     * @param 文字切れ分離制御 文字切れ分離制御
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set文字切れ分離制御(RString 文字切れ分離制御) {
        requireNonNull(文字切れ分離制御, UrSystemErrorMessages.値がnull.getReplacedMessage("文字切れ分離制御"));
        entity.setMojigireBunriSeigyo(文字切れ分離制御);
        return this;
    }

    /**
     * 定型文文字サイズを設定します。
     *
     * @param 定型文文字サイズ 定型文文字サイズ
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set定型文文字サイズ(RString 定型文文字サイズ) {
        requireNonNull(定型文文字サイズ, UrSystemErrorMessages.値がnull.getReplacedMessage("定型文文字サイズ"));
        entity.setTeikeibunMojiSize(定型文文字サイズ);
        return this;
    }

    /**
     * 口座マスク有無を設定します。
     *
     * @param 口座マスク有無 口座マスク有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set口座マスク有無(boolean 口座マスク有無) {
        requireNonNull(口座マスク有無, UrSystemErrorMessages.値がnull.getReplacedMessage("口座マスク有無"));
        entity.setKozaMaskUmu(口座マスク有無);
        return this;
    }

    /**
     * 口座名義人カナ優先区分を設定します。
     *
     * @param 口座名義人カナ優先区分 口座名義人カナ優先区分
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set口座名義人カナ優先区分(RString 口座名義人カナ優先区分) {
        requireNonNull(口座名義人カナ優先区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人カナ優先区分"));
        entity.setKozaMeigininKanaYusenKubun(口座名義人カナ優先区分);
        return this;
    }

    /**
     * 代行プリント有無を設定します。
     *
     * @param 代行プリント有無 代行プリント有無
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set代行プリント有無(boolean 代行プリント有無) {
        requireNonNull(代行プリント有無, UrSystemErrorMessages.値がnull.getReplacedMessage("代行プリント有無"));
        entity.setDaikoPrintUmu(代行プリント有無);
        return this;
    }

    /**
     * 地区表示1を設定します。
     *
     * @param 地区表示1 地区表示1
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set地区表示1(RString 地区表示1) {
        requireNonNull(地区表示1, UrSystemErrorMessages.値がnull.getReplacedMessage("地区表示1"));
        entity.setChikuHyoji1(地区表示1);
        return this;
    }

    /**
     * 地区表示2を設定します。
     *
     * @param 地区表示2 地区表示2
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set地区表示2(RString 地区表示2) {
        requireNonNull(地区表示2, UrSystemErrorMessages.値がnull.getReplacedMessage("地区表示2"));
        entity.setChikuHyoji2(地区表示2);
        return this;
    }

    /**
     * 地区表示3を設定します。
     *
     * @param 地区表示3 地区表示3
     * @return {@link ChohyoSeigyoKyotsuBuilder}
     */
    public ChohyoSeigyoKyotsuBuilder set地区表示3(RString 地区表示3) {
        requireNonNull(地区表示3, UrSystemErrorMessages.値がnull.getReplacedMessage("地区表示3"));
        entity.setChikuHyoji3(地区表示3);
        return this;
    }

    /**
     * {@link ChohyoSeigyoKyotsu}のインスタンスを生成します。
     *
     * @return {@link ChohyoSeigyoKyotsu}のインスタンス
     */
    public ChohyoSeigyoKyotsu build() {
        return new ChohyoSeigyoKyotsu(entity, id);
    }

    /**
     * setChohyoSeigyoKyotsu
     *
     * @param createChohyoSeigyoKyotsu ChohyoSeigyoKyotsuControl
     * @return ChohyoSeigyoKyotsuBuilder
     */
    public ChohyoSeigyoKyotsuBuilder setChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuControl createChohyoSeigyoKyotsu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * setChohyoSeigyoHanyo
     *
     * @param createChohyoSeigyoHanyo ChohyoSeigyoHanyo
     * @return ChohyoSeigyoKyotsuBuilder
     */
    public ChohyoSeigyoKyotsuBuilder setChohyoSeigyoHanyo(ChohyoSeigyoHanyo createChohyoSeigyoHanyo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
