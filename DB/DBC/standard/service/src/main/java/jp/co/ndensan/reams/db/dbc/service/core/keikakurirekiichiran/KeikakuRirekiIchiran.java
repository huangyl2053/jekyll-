/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.keikakurirekiichiran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.keikakurirekiichiran.KeikakuRireki;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.keikakurirekiichiran.KeikakuRirekiIchiranEnitity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.keikakurirekiichiran.IKeikakuRirekiIchiranMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCKD00002_計画履歴一覧（画面）するクラスです。
 *
 * @reamsid_L DBC-4350-080 liuxiaoyu
 */
public class KeikakuRirekiIchiran {

    private final MapperProvider mapperProvider;
    private final DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac;
    private final RString data_A = new RString("A");
    private final RString data_B = new RString("B");
    private final AtenaMeisho 定数_自己作成 = new AtenaMeisho("自己作成");
    private final RString 準拠する = new RString('1');
    private final RString 準拠しない = new RString('0');
    private final RString データあり = new RString("1");
    private final RString データなし = new RString("0");
    private final RString 定数_暫定 = new RString("暫定");
    private static final RString キー_被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです。
     */
    public KeikakuRirekiIchiran() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        介護事業者指定サービスDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KeikakuRirekiIchiran}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KeikakuRirekiIchiran}のインスタンス
     */
    public static KeikakuRirekiIchiran createInstance() {
        return InstanceProvider.create(KeikakuRirekiIchiran.class);
    }

    /**
     * 計画履歴一覧情報取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KeikakuRireki>
     */
    public List<KeikakuRireki> getKeikakuRirekiIchiranJoho(HihokenshaNo 被保険者番号) {

        List<KeikakuRireki> list = new ArrayList<>();

        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_被保険者番号.toString(), 被保険者番号);

        IKeikakuRirekiIchiranMapper mapper = mapperProvider.create(IKeikakuRirekiIchiranMapper.class);
        List<KeikakuRirekiIchiranEnitity> entityList = mapper.select居宅給付計画届出情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        for (KeikakuRirekiIchiranEnitity keienitity : entityList) {
            KeikakuRireki 計画履歴一覧情報 = new KeikakuRireki();
            if (data_A.equals(keienitity.getKyotakuKeikakuShurui())) {
                計画履歴一覧情報.set計画事業者名称(get事業者名称(keienitity.getTekiyoKaishiYMD(), keienitity.getKeikakuJigyoshaNo()));
                計画履歴一覧情報.set委託先事業者名称(get事業者名称(keienitity.getTekiyoKaishiYMD(), keienitity.getItakusakiJigyoshaNo()));
            } else if (data_B.equals(keienitity.getKyotakuKeikakuShurui())) {
                計画履歴一覧情報.set計画事業者名称(定数_自己作成);
            }
            if (データあり.equals(keienitity.getZanteiKubun())) {
                計画履歴一覧情報.set暫定状態(定数_暫定);
            } else if (データなし.equals(keienitity.getZanteiKubun())) {
                計画履歴一覧情報.set暫定状態(RString.EMPTY);
            }
            計画履歴一覧情報.set適用開始日(keienitity.getTekiyoKaishiYMD());
            計画履歴一覧情報.set適用終了日(keienitity.getTekiyoShuryoYMD());
            計画履歴一覧情報.set計画事業者番号(keienitity.getKeikakuJigyoshaNo());
            計画履歴一覧情報.set委託先事業者番号(keienitity.getItakusakiJigyoshaNo());
            list.add(計画履歴一覧情報);
        }
        return list;

    }

    private AtenaMeisho get事業者名称(FlexibleDate tekiyoKaishiYMD, JigyoshaNo keikakuJigyoshaNo) {
        AtenaMeisho atenameisho = null;
        if (keikakuJigyoshaNo == null || keikakuJigyoshaNo.isEmpty()) {
            return null;
        }
        AtenaMeisho 介護事業者_事業者名称 = null;
        DbT7060KaigoJigyoshaEntity dbt7060entity = 介護事業者Dac.select_事業者名称(tekiyoKaishiYMD, keikakuJigyoshaNo);
        if (dbt7060entity != null) {
            介護事業者_事業者名称 = dbt7060entity.getJigyoshaName();
        }
        AtenaMeisho 介護事業者指定サービス_事業者名称;
        DbT7063KaigoJigyoshaShiteiServiceEntity dbt7063entity = 介護事業者指定サービスDac.select_事業者名称(tekiyoKaishiYMD, keikakuJigyoshaNo);
        if (dbt7063entity != null) {
            介護事業者指定サービス_事業者名称 = dbt7063entity.getJigyoshaName();
        } else {
            return 介護事業者_事業者名称;
        }
        if (準拠する.equals(dbt7063entity.getKihonJohoJunkyoKubun())) {
            return 介護事業者_事業者名称;
        } else if (準拠しない.equals(dbt7063entity.getKihonJohoJunkyoKubun())) {
            return 介護事業者指定サービス_事業者名称;
        }
        return atenameisho;
    }

}
