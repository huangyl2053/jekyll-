/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * {@link ChohyoBunruiKanri}の編集を行うビルダークラスです。
 */
public class ChohyoBunruiKanriBuilder {

    private final DbT7068ChohyoBunruiKanriEntity entity;
    private final ChohyoBunruiKanriIdentifier id;

    /**
     * {@link DbT7068ChohyoBunruiKanriEntity}より{@link ChohyoBunruiKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7068ChohyoBunruiKanriEntity}
     * @param id {@link ChohyoBunruiKanriIdentifier}
     *
     */
    ChohyoBunruiKanriBuilder(
            DbT7068ChohyoBunruiKanriEntity entity,
            ChohyoBunruiKanriIdentifier id
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
     * @return {@link ChohyoBunruiKanriBuilder}
     */
    public ChohyoBunruiKanriBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID 帳票ID
     * @return {@link ChohyoBunruiKanriBuilder}
     */
    public ChohyoBunruiKanriBuilder set帳票ID(ReportId 帳票ID) {
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        entity.setReportID(帳票ID);
        return this;
    }

    /**
     * 帳票分類IDを設定します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return {@link ChohyoBunruiKanriBuilder}
     */
    public ChohyoBunruiKanriBuilder set帳票分類ID(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        entity.setChohyoBunruiID(帳票分類ID);
        return this;
    }

    /**
     * {@link ChohyoBunruiKanri}のインスタンスを生成します。
     *
     * @return {@link ChohyoBunruiKanri}のインスタンス
     */
    public ChohyoBunruiKanri build() {
        return new ChohyoBunruiKanri(entity, id);
    }
}
