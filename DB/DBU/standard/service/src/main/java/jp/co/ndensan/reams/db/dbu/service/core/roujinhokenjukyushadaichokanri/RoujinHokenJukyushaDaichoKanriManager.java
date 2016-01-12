/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.roujinhokenjukyushadaichokanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7005RojinHokenJukyushaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老人保健受給者台帳管理するクラスです。
 *
 */
public class RoujinHokenJukyushaDaichoKanriManager {

    private final DbT7005RojinHokenJukyushaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public RoujinHokenJukyushaDaichoKanriManager() {
        dac = InstanceProvider.create(DbT7005RojinHokenJukyushaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7005RojinHokenJukyushaJohoDac}
     */
    RoujinHokenJukyushaDaichoKanriManager(DbT7005RojinHokenJukyushaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriManager}のインスタンス
     */
    public static RoujinHokenJukyushaDaichoKanriManager createInstance() {
        return InstanceProvider.create(RoujinHokenJukyushaDaichoKanriManager.class);
    }

    /**
     * 老人保健受給者情報テーブルから老健受給情報老健受給情報を処理します。
     *
     * @param shikibetsuCode 識別コード
     * @return RojinHokenJukyushaJoho 老健受給情報老健受給情報
     */
    @Transaction
    public RojinHokenJukyushaJoho getRoukenJukyuJoho(ShikibetsuCode shikibetsuCode) {
        DbT7005RojinHokenJukyushaJohoEntity entity = dac.selectRoukenJukyuJoho(shikibetsuCode);
        entity.initializeMd5();
        RojinHokenJukyushaJoho buinessList = new RojinHokenJukyushaJoho(entity);
        return buinessList;
    }

    /**
     * 老健受給情報{@link RojinHokenJukyushaJoho}を保存します。
     *
     * @param 老健受給情報 {@link RojinHokenJukyushaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int updateOrInsertRoukenJukyuJoho(RojinHokenJukyushaJoho 老健受給情報) {
        requireNonNull(老健受給情報, UrSystemErrorMessages.値がnull.getReplacedMessage("老健受給情報"));
        if (!老健受給情報.hasChanged()) {
            return 0;
        }
        return dac.save(老健受給情報.toEntity());
    }
}
