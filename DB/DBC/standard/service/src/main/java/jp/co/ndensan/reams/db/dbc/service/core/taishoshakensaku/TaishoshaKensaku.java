/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.taishoshakensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensaku.TaishoshaKensakuResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensaku.TaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishoshakensaku.ITaishoshaKensakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）（画面）
 *
 * @reamsid_L DBC-2101-040 quxiaodong
 */
public class TaishoshaKensaku {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TaishoshaKensaku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaishoshaKensaku}のインスタンス
     */
    public static TaishoshaKensaku createInstance() {
        return InstanceProvider.create(TaishoshaKensaku.class);
    }

    /**
     * 検索条件より、受給者異動対象者一覧を取得する。
     *
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param 削除データ検索 boolean
     * @return List<TaishoshaKensakuResult>
     */
    public List<TaishoshaKensakuResult> selectJukyushaIdoTaishosha(
            FlexibleDate 異動日From,
            FlexibleDate 異動日To,
            HihokenshaNo 被保険者番号,
            boolean 削除データ検索) {
        ITaishoshaKensakuMapper mapper = mapperProvider.create(ITaishoshaKensakuMapper.class);
        TaishoshaKensakuParameter parameter
                = new TaishoshaKensakuParameter(異動日From, 異動日To, 被保険者番号, 削除データ検索);
        List<DbT3001JukyushaIdoRenrakuhyoEntity> taikensakuenList = mapper.selectJukyushaIdoTaishosha(parameter);
        if (null == taikensakuenList || taikensakuenList.isEmpty()) {
            return null;
        }
        List<TaishoshaKensakuResult> 対象者一覧情報 = new ArrayList<>();
        for (DbT3001JukyushaIdoRenrakuhyoEntity entity : taikensakuenList) {
            TaishoshaKensakuResult taikensakuenEntity = new TaishoshaKensakuResult();
            taikensakuenEntity.set対象者一覧情報Entity(new JukyushaIdoRenrakuhyo(entity));
            対象者一覧情報.add(taikensakuenEntity);
        }
        return 対象者一覧情報;
    }
}
