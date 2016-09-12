/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChohyoSeigyoHanyo}の編集を行うビルダークラスです。
 */
public class ChohyoSeigyoHanyoBuilder {

    private final DbT7067ChohyoSeigyoHanyoEntity entity;
    private final ChohyoSeigyoHanyoIdentifier id;

    /**
     * {@link DbT7067ChohyoSeigyoHanyoEntity}より{@link ChohyoSeigyoHanyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7067ChohyoSeigyoHanyoEntity}
     * @param id {@link ChohyoSeigyoHanyoIdentifier}
     *
     */
    ChohyoSeigyoHanyoBuilder(
            DbT7067ChohyoSeigyoHanyoEntity entity,
            ChohyoSeigyoHanyoIdentifier id
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
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 帳票分類IDを設定します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder set帳票分類ID(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        entity.setChohyoBunruiID(帳票分類ID);
        return this;
    }

    /**
     * 項目名を設定します。
     *
     * @param 項目名 項目名
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder set項目名(RString 項目名) {
        requireNonNull(項目名, UrSystemErrorMessages.値がnull.getReplacedMessage("項目名"));
        entity.setKomokuName(項目名);
        return this;
    }

    /**
     * 管理年度を設定します。
     *
     * @param 管理年度 管理年度
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder set管理年度(FlexibleYear 管理年度) {
        requireNonNull(管理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("管理年度"));
        entity.setKanriNendo(管理年度);
        return this;
    }

    /**
     * 設定値を設定します。
     *
     * @param 設定値 設定値
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder set設定値(RString 設定値) {
        entity.setKomokuValue(設定値);
        return this;
    }

    /**
     * 説明を設定します。
     *
     * @param 説明 説明
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder set説明(RString 説明) {
        entity.setKomokuSetsumei(説明);
        return this;
    }

    /**
     * 変更可否を設定します。
     *
     * @param 変更可否 変更可否
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder set変更可否(boolean 変更可否) {
        requireNonNull(変更可否, UrSystemErrorMessages.値がnull.getReplacedMessage("変更可否"));
        entity.setHenkoKahi(変更可否);
        return this;
    }

    /**
     * コードマスタサブ業務コードを設定します。
     *
     * @param コードマスタサブ業務コード コードマスタサブ業務コード
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder setコードマスタサブ業務コード(SubGyomuCode コードマスタサブ業務コード) {
        entity.setCodeMasterSubGyomuCode(コードマスタサブ業務コード);
        return this;
    }

    /**
     * コードマスタコード種別を設定します。
     *
     * @param コードマスタコード種別 コードマスタコード種別
     * @return {@link ChohyoSeigyoHanyoBuilder}
     */
    public ChohyoSeigyoHanyoBuilder setコードマスタコード種別(CodeShubetsu コードマスタコード種別) {
        entity.setCodeMasterCodeShubetsu(コードマスタコード種別);
        return this;
    }

    /**
     * {@link ChohyoSeigyoHanyo}のインスタンスを生成します。
     *
     * @return {@link ChohyoSeigyoHanyo}のインスタンス
     */
    public ChohyoSeigyoHanyo build() {
        return new ChohyoSeigyoHanyo(entity, id);
    }
}
