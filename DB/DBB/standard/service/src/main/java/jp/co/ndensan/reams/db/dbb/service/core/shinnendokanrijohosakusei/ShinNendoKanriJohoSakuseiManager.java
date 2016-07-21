/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shinnendokanrijohosakusei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ShinNendoKanriJohoSakuseiManagerクラスです。
 *
 * @reamsid_L DBB_5721_010 chenyadong
 */
public class ShinNendoKanriJohoSakuseiManager {

    private final ShoriDateKanriManager 処理日付管理manager;
    private final ChohyoSeigyoHanyoManager 帳票制御汎用manager;

    /**
     * コンストラクタです。
     */
    ShinNendoKanriJohoSakuseiManager() {
        this.処理日付管理manager = InstanceProvider.create(ShoriDateKanriManager.class);
        this.帳票制御汎用manager = InstanceProvider.create(ChohyoSeigyoHanyoManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 処理日付管理manager ShoriDateKanriManager
     * @param 帳票制御汎用manager ChohyoSeigyoHanyoManager
     */
    public ShinNendoKanriJohoSakuseiManager(
            ShoriDateKanriManager 処理日付管理manager,
            ChohyoSeigyoHanyoManager 帳票制御汎用manager
    ) {
        this.処理日付管理manager = 処理日付管理manager;
        this.帳票制御汎用manager = 帳票制御汎用manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinNendoKanriJohoSakuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinNendoKanriJohoSakuseiManager}のインスタンス
     */
    public static ShinNendoKanriJohoSakuseiManager createInstance() {
        return InstanceProvider.create(ShinNendoKanriJohoSakuseiManager.class);
    }

    /**
     * 追加します。
     *
     * @param 処理日付管理 ShoriDateKanri
     * @param 帳票制御汎用List List<ChohyoSeigyoHanyo>
     */
    @Transaction
    public void 追加(ShoriDateKanri 処理日付管理, List<ChohyoSeigyoHanyo> 帳票制御汎用List) {
        requireNonNull(処理日付管理, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理"));
        requireNonNull(帳票制御汎用List, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御汎用List"));
        処理日付管理manager.save処理日付管理マスタ(処理日付管理);
        for (ChohyoSeigyoHanyo item : 帳票制御汎用List) {
            帳票制御汎用manager.save帳票制御汎用(item);
        }

    }

}
