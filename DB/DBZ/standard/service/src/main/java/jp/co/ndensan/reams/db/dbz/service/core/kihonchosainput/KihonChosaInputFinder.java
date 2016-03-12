/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.entity.db.kihonchosainput.KihonChosaInputEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kihonchosainput.IKihonChosaInputMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 共有子Div「認定基本調査入力」の状態を変更するクラスです
 */
public class KihonChosaInputFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KihonChosaInputFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * インスタンスを生成します。
     *
     * @return {@link KihonChosaInputFinder}
     */
    public static KihonChosaInputFinder createInstance() {
        return InstanceProvider.create(KihonChosaInputFinder.class);
    }

    /**
     * 認定調査基本情報取得です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査基本情報リスト
     */
    @Transaction
    public List<KihonChosaInput> get認定調査基本情報(ShinseishoKanriNo 申請書管理番号) {
        IKihonChosaInputMapper mapper = mapperProvider.create(IKihonChosaInputMapper.class);
        List<KihonChosaInputEntity> 認定調査基本情報Entityリスト = mapper.get認定調査基本情報(申請書管理番号);
        List<KihonChosaInput> 認定調査基本情報リスト = new ArrayList<>();
        for (KihonChosaInputEntity 認定調査基本情報Entity : 認定調査基本情報Entityリスト) {
            KihonChosaInput 認定調査基本情報 = new KihonChosaInput(認定調査基本情報Entity);
            認定調査基本情報リスト.add(認定調査基本情報);
        }
        return 認定調査基本情報リスト;
    }

}
