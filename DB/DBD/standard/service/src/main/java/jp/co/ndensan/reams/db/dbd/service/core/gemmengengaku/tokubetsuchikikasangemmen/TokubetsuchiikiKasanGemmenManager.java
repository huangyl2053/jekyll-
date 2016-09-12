/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4020TokubetsuchiikiKasanGemmenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.tokubetsuchikikasangemmen.ITokubetsuchiikiKasanGemmenMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特別地域加算減免を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class TokubetsuchiikiKasanGemmenManager {

    private final MapperProvider mapperProvider;
    private final DbT4020TokubetsuchiikiKasanGemmenDac 特別地域加算減免Dac;
    private final GemmenGengakuShinseiManager 減免減額申請Manager;

    /**
     * コンストラクタです。
     */
    TokubetsuchiikiKasanGemmenManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.特別地域加算減免Dac = InstanceProvider.create(DbT4020TokubetsuchiikiKasanGemmenDac.class);
        this.減免減額申請Manager = new GemmenGengakuShinseiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 特別地域加算減免Dac 特別地域加算減免Dac
     * @param 減免減額申請Manager 減免減額申請Manager
     */
    TokubetsuchiikiKasanGemmenManager(
            MapperProvider mapperProvider,
            DbT4020TokubetsuchiikiKasanGemmenDac 特別地域加算減免Dac,
            GemmenGengakuShinseiManager 減免減額申請Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.特別地域加算減免Dac = 特別地域加算減免Dac;
        this.減免減額申請Manager = 減免減額申請Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokubetsuchiikiKasanGemmenManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokubetsuchiikiKasanGemmenManager}のインスタンス
     */
    public static TokubetsuchiikiKasanGemmenManager createInstance() {
        return InstanceProvider.create(TokubetsuchiikiKasanGemmenManager.class);
    }

    /**
     * 主キーに合致する特別地域加算減免を返します。
     *
     * @param 特別地域加算減免検索条件 特別地域加算減免検索条件
     * @return TokubetsuchiikiKasanGemmen 【　※ツールの都合上、このカッコ部は手動で削除して下さい 特別地域加算減免】 nullが返る可能性があります。
     */
    @Transaction
    public TokubetsuchiikiKasanGemmen get特別地域加算減免(TokubetsuchiikiKasanGemmenMapperParameter 特別地域加算減免検索条件) {
        requireNonNull(特別地域加算減免検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算減免検索条件"));
        ITokubetsuchiikiKasanGemmenMapper mapper = mapperProvider.create(ITokubetsuchiikiKasanGemmenMapper.class);

        TokubetsuchiikiKasanGemmenEntity relateEntity = mapper.select特別地域加算減免ByKey(特別地域加算減免検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new TokubetsuchiikiKasanGemmen(relateEntity);
    }

    /**
     * 特別地域加算減免{@link TokubetsuchiikiKasanGemmen}を保存します。
     *
     * @param 特別地域加算減免 特別地域加算減免
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(TokubetsuchiikiKasanGemmen 特別地域加算減免) {
        requireNonNull(特別地域加算減免, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算減免"));

        if (!特別地域加算減免.hasChanged()) {
            return false;
        }
        特別地域加算減免 = 特別地域加算減免.modifiedModel();
        save減免減額申請リスト(特別地域加算減免.getGemmenGengakuShinseiList());
        return 1 == 特別地域加算減免Dac.save(特別地域加算減免.toEntity());
    }

    private void save減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.save減免減額申請(減免減額申請);
        }
    }

    /**
     * 被保険者番号、減免減額種類、履歴番号により、取得された特別地域加算減免情報リストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return TokubetsuchiikiKasanGemmen 【　※ツールの都合上、このカッコ部は手動で削除して下さい 特別地域加算減免】 nullが返る可能性があります。
     */
    @Transaction
    public TokubetsuchiikiKasanGemmen get特別地域加算減免(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        ITokubetsuchiikiKasanGemmenMapper mapper = mapperProvider.create(ITokubetsuchiikiKasanGemmenMapper.class);
        NinteiJohoParameter 検索条件 = NinteiJohoParameter.createParameter(被保険者番号, 減免減額種類, 履歴番号);
        TokubetsuchiikiKasanGemmenEntity relateEntity = mapper.select特別地域加算減免(検索条件);
        relateEntity.initializeMd5ToEntities();
        return new TokubetsuchiikiKasanGemmen(relateEntity);
    }
}
