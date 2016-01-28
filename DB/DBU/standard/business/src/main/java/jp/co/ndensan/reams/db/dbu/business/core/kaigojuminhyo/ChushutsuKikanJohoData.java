/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author lijia
 */
public class ChushutsuKikanJohoData implements Serializable {

    private final DbT7022ShoriDateKanriEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7022ShoriDateKanriEntity}より{@link ChushutsuKikanJohoData}を生成します。
     *
     * @param entity DBより取得した{@link DbT7021JigyoHokokuTokeiDataEntity}
     */
    public ChushutsuKikanJohoData(DbT7022ShoriDateKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理データ"));
    }

    //TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 対象開始年月日を返します。
     *
     * @return 対象開始年月日
     */
    public RString get対象開始年月日() {
        return new RString(entity.getTaishoKaishiYMD().toString());
    }

    /**
     * 対象終了年月日を返します。
     *
     * @return 対象終了年月日
     */
    public RString get対象終了年月日() {
        return new RString(entity.getTaishoShuryoYMD().toString());
    }

    /**
     * 対象開始日時を返します。
     *
     * @return 対象開始日時
     */
    public RString get対象開始日時() {
        return new RString(entity.getTaishoKaishiTimestamp().toString());
    }

    /**
     * 対象終了年月日を返します。
     *
     * @return 対象終了年月日
     */
    public RString get対象終了日時() {
        return new RString(entity.getTaishoShuryoTimestamp().toString());
    }
}
