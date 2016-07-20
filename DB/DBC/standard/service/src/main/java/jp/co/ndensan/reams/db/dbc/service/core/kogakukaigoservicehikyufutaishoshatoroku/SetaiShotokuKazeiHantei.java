/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiJigyoHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.ISetaiiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 世帯所得・課税判定です。
 *
 * @reamsid_L DBC-2010-090 jiangzongyue
 */
public class SetaiShotokuKazeiHantei {

    private final MapperProvider mapperProvider;
    private static final RString メニューID_高額介護サービス = new RString("DBCMN41002");
    private static final RString メニューID_事業高額介護サービス = new RString("DBCMN41004");

    /**
     * コンストラクタです。
     */
    SetaiShotokuKazeiHantei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    SetaiShotokuKazeiHantei(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンス
     */
    public static SetaiShotokuKazeiHantei createInstance() {
        return InstanceProvider.create(SetaiShotokuKazeiHantei.class);
    }

    /**
     * 世帯員把握入力高額一時の中で「住所地特例該当」が「１」のデータを取得します。
     *
     * @param 管理識別区分 {@link JukyushaDaichoMapperParameter}
     */
    @Transaction
    public void getSetaiinHaaku(RString 管理識別区分) {
        requireNonNull(管理識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理識別区分"));
        ISetaiiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiiShotokuKazeiHanteiMapper.class);
        mapper.insert世帯員所得情報高額一時に一括住所地特例該当が1();
        mapper.insert世帯員所得情報高額一時に一括住所地特例該当が1以外(new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分));
        TempSetaiinHaakuNyuryokuEntity tempSetaiEntity = mapper.select世帯員所得情報高額一時に一括();
        ISetaiFinder 世帯Finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai 世帯 = 世帯Finder.findBy識別コード(GyomuCode.DB介護保険, tempSetaiEntity.getShikibetsuCode(), tempSetaiEntity.getKijunYMD());
        世帯.getSetaiCode();
        IKojins 世帯員リスト = 世帯.get世帯員リスト();
        for (IKojin 世帯員 : 世帯員リスト) {
            世帯員.get識別コード();
        }

        mapper.insert世帯員所得情報事業高額一時に一括住所地特例該当が1();
        mapper.insert世帯員所得情報事業高額一時に一括住所地特例該当が1以外(new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分));
    }

    /**
     * 世帯員把握入力高額一時の中で「住所地特例該当」が「１」のデータを取得します。
     *
     */
    @Transaction
    public void convertGappeinaiJutokushaShinKyuNo() {
        ISetaiiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiiShotokuKazeiHanteiMapper.class);
        mapper.update世帯員所得情報高額一時合併内住所地特例者番号変換処理();
        mapper.update世帯員所得情報事業高額一時合併内住所地特例者番号変換処理();
    }

    /**
     * 合併内住特者番号変換処理取得します。
     *
     */
    @Transaction
    public void getJuminShotokuJoho() {
        ISetaiiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiiShotokuKazeiHanteiMapper.class);
        mapper.update高額介護サービス場合();
        TmpSetaiHaakuNyuryokuEntity 生保区分entity = mapper.select取得した内容で世帯員所得情報高額一時に生保区分を更新();
        if (生保区分entity != null) {
            mapper.update世帯員所得情報高額一時生保区分を付加する();
        }
        TmpSetaiHaakuNyuryokuEntity 老齢福祉区分entity = mapper.select取得した内容で世帯員所得情報高額一時に老齢福祉区分を更新();
        if (老齢福祉区分entity != null) {
            mapper.update世帯員所得情報高額一時老齢福祉区分を更新する();
        }
        mapper.update事業高額介護サービス場合();
        TmpSetaiJigyoHaakuNyuryokuEntity 事業生保区分entity = mapper.select取得した内容で世帯員所得情報事業高額一時に生保区分を更新();
        if (事業生保区分entity != null) {
            mapper.update世帯員所得情報事業高額一時生保区分を付加する();
        }
        TmpSetaiJigyoHaakuNyuryokuEntity 事業老齢福祉区分entity = mapper.select取得した内容で世帯員所得情報事業高額一時に老齢福祉区分を更新();
        if (事業老齢福祉区分entity != null) {
            mapper.update世帯員所得情報事業高額一時老齢福祉区分を更新する();
        }
    }

    private boolean is高額介護サービス(RString メニューID) {
        return メニューID_高額介護サービス.equals(メニューID);
    }

    private boolean is事業高額介護サービス(RString メニューID) {
        return メニューID_事業高額介護サービス.equals(メニューID);
    }
}
