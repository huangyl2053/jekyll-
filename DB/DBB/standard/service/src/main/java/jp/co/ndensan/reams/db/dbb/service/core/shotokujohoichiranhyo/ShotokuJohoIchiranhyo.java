/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohoichiranhyo.TaishoShuryoYmd;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyo.ShotokuJohoIchiranhyoKouikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyo.ShotokuJohoIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.shotokujohoichiranhyo.TaishoShuryoYmdEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokujohoichiranhyo.IShotokuJohoIchiranhyoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51003_所得情報一覧表作成のクラス
 *
 * @reamsid_L DBB-1650-030 lijunjun
 */
public class ShotokuJohoIchiranhyo {

    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 導入形態コード_111 = new RString("111");
    private final MapperProvider mapperProvider;

    ShotokuJohoIchiranhyo() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    ShotokuJohoIchiranhyo(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShotokuJohoIchiranhyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShotokuJohoIchiranhyo}のインスタンス
     */
    public static ShotokuJohoIchiranhyo createInstance() {
        return InstanceProvider.create(ShotokuJohoIchiranhyo.class);
    }

    /**
     * 対象終了日時取得
     *
     * @param 導入形態コード RString
     * @param 市町村コード LasdecCode
     * @param 広域現市町村リスト List<KoikiZenShichosonJoho>
     * @param 処理年度 FlexibleYear
     * @return List<TaishoShuryoYmd>
     */
    public List<TaishoShuryoYmd> getTaishoShuryoNichiji(RString 導入形態コード,
            LasdecCode 市町村コード,
            List<KoikiZenShichosonJoho> 広域現市町村リスト,
            FlexibleYear 処理年度) {
        if (導入形態コード == null || 市町村コード == null || (広域現市町村リスト == null || 広域現市町村リスト.isEmpty())
                || 処理年度 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        List<TaishoShuryoYmdEntity> 対象終了日時List = new ArrayList<>();
        IShotokuJohoIchiranhyoMapper mapper = mapperProvider.create(IShotokuJohoIchiranhyoMapper.class);
        if (導入形態コード.equals(導入形態コード_112) || 導入形態コード.equals(導入形態コード_120)) {
            ShotokuJohoIchiranhyoKouikiParameter 対象終了日時par = new ShotokuJohoIchiranhyoKouikiParameter();
            対象終了日時par.set処理年度(処理年度);
            対象終了日時par.set市町村コード(市町村コード);
            対象終了日時List = mapper.select対象終了日時(対象終了日時par);
        }
        if (導入形態コード.equals(導入形態コード_111)) {
            List<LasdecCode> 市町村コードリスト = new ArrayList<>();
            List<RString> 市町村識別IDリスト = new ArrayList<>();
            RString 市町村識別ＩＤ;
            for (KoikiZenShichosonJoho chosonJoho : 広域現市町村リスト) {
                市町村識別ＩＤ = chosonJoho.get市町村識別ID();
                市町村コード = chosonJoho.get市町村コード();
                市町村コードリスト.add(市町村コード);
                市町村識別IDリスト.add(市町村識別ＩＤ);
            }
            ShotokuJohoIchiranhyoParameter 対象終了日時_広域par = new ShotokuJohoIchiranhyoParameter();
            対象終了日時_広域par.set処理年度(処理年度);
            対象終了日時_広域par.set市町村コードリスト(市町村コードリスト);
            対象終了日時_広域par.set市町村識別IDリスト(市町村識別IDリスト);
            対象終了日時List = mapper.select対象終了日時_広域(対象終了日時_広域par);
        }
        List<TaishoShuryoYmd> 対象終了日時リスト = new ArrayList<>();
        TaishoShuryoYmd 対象終了日時;
        for (TaishoShuryoYmdEntity entity : 対象終了日時List) {
            対象終了日時 = new TaishoShuryoYmd(entity);
            対象終了日時リスト.add(対象終了日時);
        }
        return 対象終了日時リスト;
    }
}
