/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd3020003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JikoKisambiKanri;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukokisambitokushutoroku.IJukoKisambiTokushuTorokuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 時効起算日特殊登録情報取得のクラスです。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public class JukoKisambiTokushuTorokuManager {

    private final MapperProvider mapperProvider;

    JukoKisambiTokushuTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    JukoKisambiTokushuTorokuManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * JukoKisambiTokushuTorokuManagerのインスタンス化
     *
     * @return JukoKisambiTokushuTorokuManager
     */
    public static JukoKisambiTokushuTorokuManager createInstance() {
        return InstanceProvider.create(JukoKisambiTokushuTorokuManager.class);
    }

    /**
     * 初期化情報を取得取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 調定年度 RYear
     * @return JikoKisambiKanri
     */
    public List<JikoKisambiKanri> get時効起算日管理(HihokenshaNo 被保険者番号, RYear 調定年度) {
        IJukoKisambiTokushuTorokuMapper mapper = mapperProvider.create(IJukoKisambiTokushuTorokuMapper.class);
        List<DbT4023JikoKisambiKanriEntity> entities = mapper.get時効起算日管理(被保険者番号, 調定年度);

        List<JikoKisambiKanri> resultList = new ArrayList<>();
        for (DbT4023JikoKisambiKanriEntity entity : entities) {
            resultList.add(new JikoKisambiKanri(entity));
        }
        return resultList;
    }
}
