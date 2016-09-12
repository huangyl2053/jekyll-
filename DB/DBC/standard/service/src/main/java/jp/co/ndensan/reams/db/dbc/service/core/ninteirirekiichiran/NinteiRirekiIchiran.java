/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.ninteirirekiichiran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.ninteirirekiichiran.JyukyuuSyaDaiTyouResult;
import jp.co.ndensan.reams.db.dbc.business.core.ninteirirekiichiran.SogoJigyouTaisyouSyaJyohoResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.ninteirirekiichiran.JyukyuuSyaDaiTyouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.ninteirirekiichiran.INinteiRirekiIchiranMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定履歴一覧（画面）
 *
 * @reamsid_L DBC-4350-070 wangxingpeng
 */
public class NinteiRirekiIchiran {

    private final MapperProvider mapperProvider;
    private final RString 定数_被保険者番号 = new RString("被保険者番号");
    private final DbT3105SogoJigyoTaishoshaDac 総合事業対象者情報取得Dac;

    /**
     * コンストラクタです
     */
    NinteiRirekiIchiran() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        総合事業対象者情報取得Dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
    }

    /**
     *
     * @param mapperProvider MapperProvider
     * @param 総合事業対象者情報取得Dac DbT3105SogoJigyoTaishoshaDac
     */
    NinteiRirekiIchiran(MapperProvider mapperProvider, DbT3105SogoJigyoTaishoshaDac 総合事業対象者情報取得Dac) {
        this.mapperProvider = mapperProvider;
        this.総合事業対象者情報取得Dac = 総合事業対象者情報取得Dac;
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return
     * {@link InstanceProvider#create}により生成された{@link NinteiRirekiIchiran}
     */
    public static NinteiRirekiIchiran createInstance() {
        return InstanceProvider.create(NinteiRirekiIchiran.class);
    }

    /**
     * 受給者台帳情報取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<JyukyuuSyaDaiTyouResult> 受給者台帳情報
     */
    public List<JyukyuuSyaDaiTyouResult> getJyukyuuSyaDaiTyouJyoho(HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            return new ArrayList<>();
        }
        INinteiRirekiIchiranMapper mapper = mapperProvider.create(INinteiRirekiIchiranMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put(定数_被保険者番号.toString(), 被保険者番号);
        List<JyukyuuSyaDaiTyouEntity> resultList = mapper.select受給者台帳情報取得(map);
        if (resultList == null || resultList.isEmpty()) {
            return new ArrayList<>();
        }
        List<JyukyuuSyaDaiTyouResult> list = new ArrayList<>();
        for (JyukyuuSyaDaiTyouEntity entity : resultList) {
            JyukyuuSyaDaiTyouResult result = new JyukyuuSyaDaiTyouResult();
            result.setみなし区分(entity.getみなし区分());
            result.set申請種別(entity.get申請種別());
            result.set要介護認定状態区分(entity.get要介護認定状態区分());
            result.set申請日(entity.get申請日());
            result.set認定有効終了日(entity.get認定有効終了日());
            result.set認定有効開始日(entity.get認定有効開始日());
            result.set旧措置者フラグ(entity.is旧措置者フラグ());
            list.add(result);
        }
        return list;
    }

    /**
     * 総合事業対象者情報取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<SogoJigyouTaisyouSyaJyohoResult> 総合事業対象者情報
     */
    public List<SogoJigyouTaisyouSyaJyohoResult> getSogoJigyouTaisyouSyaJyoho(HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            return new ArrayList<>();
        }
        List<DbT3105SogoJigyoTaishoshaEntity> resultList = 総合事業対象者情報取得Dac.selectBy被保険者番号(被保険者番号);
        if (resultList == null || resultList.isEmpty()) {
            return new ArrayList<>();
        }
        List<SogoJigyouTaisyouSyaJyohoResult> list = new ArrayList<>();
        for (DbT3105SogoJigyoTaishoshaEntity entity : resultList) {
            SogoJigyouTaisyouSyaJyohoResult result = new SogoJigyouTaisyouSyaJyohoResult();
            result.setチェックリスト実施日(entity.getChecklistJisshiYMD());
            result.set決定日(entity.getKetteiYMD());
            result.set適用開始日(entity.getTekiyoKaishiYMD());
            result.set適用終了日(entity.getTekiyoShuryoYMD());
            list.add(result);
        }
        return list;
    }
}
