/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson.ChikuShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson.ChikuShichosonIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ChikuNinteiChosain}の編集を行うビルダークラスです。
 */
public class ChikuNinteiChosainBuilder {

    private final DbT5223ChikuNinteiChosainEntity entity;
    private final ChikuNinteiChosainIdentifier id;
    private final Models<ChikuShichosonIdentifier, ChikuShichoson> chikuShichoson;

    /**
     * {@link DbT5223ChikuNinteiChosainEntity}より{@link ChikuNinteiChosain}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5223ChikuNinteiChosainEntity}
     * @param id {@link ChikuNinteiChosainIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     */
    ChikuNinteiChosainBuilder(
            DbT5223ChikuNinteiChosainEntity entity,
            ChikuNinteiChosainIdentifier id,
            Models<ChikuShichosonIdentifier, ChikuShichoson> chikushichoson) {
    
        this.entity = entity.clone();
        this.id = id;
        this.chikuShichoson = chikushichoson.clone();
    }

    /**
     * 優先番号を設定します。
     *
     * @param 優先番号 優先番号
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set優先番号(int 優先番号) {
        requireNonNull(優先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("優先番号"));
        entity.setYusenNo(優先番号);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 精神手帳任意項目情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる精神手帳任意項目情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は精神手帳任意項目情報リストに精神手帳任意項目情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 地区市町村情報 {@link ChikuShichoson}
     * @return {@link ChikuNinteiChosainBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ChikuNinteiChosainBuilder setSeishinTechoNini(ChikuShichoson 地区市町村情報) {
        if (hasSameIdentifier(地区市町村情報.identifier())) {
            chikuShichoson.add(地区市町村情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ChikuShichosonIdentifier 地区市町村の識別子) {
        return (id.get市町村コード().equals(地区市町村の識別子.get市町村コード())
                && id.get調査地区コード().equals(地区市町村の識別子.get調査地区コード()));
    }
    /**
     * {@link ChikuNinteiChosain}のインスタンスを生成します。
     *
     * @return {@link ChikuNinteiChosain}のインスタンス
     */
    public ChikuNinteiChosain build() {
        return new ChikuNinteiChosain(entity, id, chikuShichoson);
    }
}
