/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoToiawasesaki}の編集を行うビルダークラスです。
 */
public class KaigoToiawasesakiBuilder {

    private final DbT7069KaigoToiawasesakiEntity entity;
    private final KaigoToiawasesakiIdentifier id;

    /**
     * {@link DbT7069KaigoToiawasesakiEntity}より{@link KaigoToiawasesaki}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7069KaigoToiawasesakiEntity}
     * @param id {@link KaigoToiawasesakiIdentifier}
     *
     */
    KaigoToiawasesakiBuilder(
            DbT7069KaigoToiawasesakiEntity entity,
            KaigoToiawasesakiIdentifier id
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
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 帳票分類IDを設定します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set帳票分類ID(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        entity.setChohyoBunruiID(帳票分類ID);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 所在地を設定します。
     *
     * @param 所在地 所在地
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set所在地(RString 所在地) {
        requireNonNull(所在地, UrSystemErrorMessages.値がnull.getReplacedMessage("所在地"));
        entity.setShozaichi(所在地);
        return this;
    }

    /**
     * 庁舎名を設定します。
     *
     * @param 庁舎名 庁舎名
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set庁舎名(RString 庁舎名) {
        requireNonNull(庁舎名, UrSystemErrorMessages.値がnull.getReplacedMessage("庁舎名"));
        entity.setChoshaName(庁舎名);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * 内線番号を設定します。
     *
     * @param 内線番号 内線番号
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set内線番号(RString 内線番号) {
        requireNonNull(内線番号, UrSystemErrorMessages.値がnull.getReplacedMessage("内線番号"));
        entity.setNaisenNo(内線番号);
        return this;
    }

    /**
     * 部署名を設定します。
     *
     * @param 部署名 部署名
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set部署名(RString 部署名) {
        requireNonNull(部署名, UrSystemErrorMessages.値がnull.getReplacedMessage("部署名"));
        entity.setBushoName(部署名);
        return this;
    }

    /**
     * 担当者名を設定します。
     *
     * @param 担当者名 担当者名
     * @return {@link KaigoToiawasesakiBuilder}
     */
    public KaigoToiawasesakiBuilder set担当者名(RString 担当者名) {
        requireNonNull(担当者名, UrSystemErrorMessages.値がnull.getReplacedMessage("担当者名"));
        entity.setTantoshaName(担当者名);
        return this;
    }

    /**
     * {@link KaigoToiawasesaki}のインスタンスを生成します。
     *
     * @return {@link KaigoToiawasesaki}のインスタンス
     */
    public KaigoToiawasesaki build() {
        return new KaigoToiawasesaki(entity, id);
    }
}
