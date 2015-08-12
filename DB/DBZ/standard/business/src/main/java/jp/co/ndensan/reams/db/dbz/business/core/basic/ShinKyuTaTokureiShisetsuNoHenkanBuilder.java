/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinKyuTaTokureiShisetsuNoHenkan}の編集を行うビルダークラスです。
 */
public class ShinKyuTaTokureiShisetsuNoHenkanBuilder {

    private final DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity;
    private final ShinKyuTaTokureiShisetsuNoHenkanIdentifier id;

    /**
     * {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}より{@link ShinKyuTaTokureiShisetsuNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}
     * @param id {@link ShinKyuTaTokureiShisetsuNoHenkanIdentifier}
     *
     */
    ShinKyuTaTokureiShisetsuNoHenkanBuilder(
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity,
            ShinKyuTaTokureiShisetsuNoHenkanIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTaTokureiShisetsuNoHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 新他特例施設番号を設定します。
     *
     * @param 新他特例施設番号 新他特例施設番号
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTaTokureiShisetsuNoHenkanBuilder set新他特例施設番号(RString 新他特例施設番号) {
        requireNonNull(新他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新他特例施設番号"));
        entity.setShinTaTokureiShisetsuNo(新他特例施設番号);
        return this;
    }

    /**
     * 旧他特例施設番号を設定します。
     *
     * @param 旧他特例施設番号 旧他特例施設番号
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTaTokureiShisetsuNoHenkanBuilder set旧他特例施設番号(RString 旧他特例施設番号) {
        requireNonNull(旧他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号"));
        entity.setKyuTaTokureiShisetsuNo(旧他特例施設番号);
        return this;
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTaTokureiShisetsuNoHenkanBuilder set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
        return this;
    }

    /**
     * 旧他特例施設番号２を設定します。
     *
     * @param 旧他特例施設番号２ 旧他特例施設番号２
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTaTokureiShisetsuNoHenkanBuilder set旧他特例施設番号２(RString 旧他特例施設番号２) {
        requireNonNull(旧他特例施設番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号２"));
        entity.setKyuTaTokureiShisetsuNo2(旧他特例施設番号２);
        return this;
    }

    /**
     * {@link ShinKyuTaTokureiShisetsuNoHenkan}のインスタンスを生成します。
     *
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkan}のインスタンス
     */
    public ShinKyuTaTokureiShisetsuNoHenkan build() {
        return new ShinKyuTaTokureiShisetsuNoHenkan(entity, id);
    }
}
