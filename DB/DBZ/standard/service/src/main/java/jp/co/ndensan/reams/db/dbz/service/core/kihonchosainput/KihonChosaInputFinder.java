/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaSpecial;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaInputEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaSpecialEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kihonchosainput.IKihonChosaInputMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 共有子Div「認定基本調査入力」の状態を変更するクラスです
 *
 * @reamsid_L DBE-3000-090 wangjie2
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
            if (null == 認定調査基本情報Entity) {
                continue;
            }
            KihonChosaInput 認定調査基本情報 = new KihonChosaInput(認定調査基本情報Entity);
            認定調査基本情報リスト.add(認定調査基本情報);
        }
        return 認定調査基本情報リスト;
    }

    /**
     * 認定調査特記情報取得です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査特記情報リスト
     */
    @Transaction
    public List<KihonChosaSpecial> get認定調査特記情報(ShinseishoKanriNo 申請書管理番号) {
        IKihonChosaInputMapper mapper = mapperProvider.create(IKihonChosaInputMapper.class);
        List<KihonChosaSpecialEntity> 認定調査特記情報Entityリスト = mapper.get認定調査特記情報(申請書管理番号);
        List<KihonChosaSpecial> 認定調査特記情報リスト = new ArrayList<>();
        for (KihonChosaSpecialEntity 認定調査特記情報Entity : 認定調査特記情報Entityリスト) {
            if (null == 認定調査特記情報Entity) {
                continue;
            }
            KihonChosaSpecial 認定調査特記情報 = new KihonChosaSpecial(認定調査特記情報Entity);
            認定調査特記情報リスト.add(認定調査特記情報);
        }
        return 認定調査特記情報リスト;
    }

}
