/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成のProcessParameterです。
 *
 * @reamsid_L DBC-5020-040 zhaoyao
 */
@lombok.Getter
@lombok.Setter
public class KenkouKaruteRenkeiDataProcessParameter implements IBatchProcessParameter {

    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタ作成です。
     *
     * @param psmShikibetsuTaisho RString
     */
    public KenkouKaruteRenkeiDataProcessParameter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 健康かるて連携データ作成のProcessParameter作成。
     *
     * @return KenkouKaruteRenkeiDataProcessParameter
     */
    public KenkouKaruteRenkeiDataProcessParameter createKenkouKaruteRenkeiDataProcessParameter() {
//        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
//                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先))
//                .setデータ取得区分(DataShutokuKubun.直近レコード);
//        List<JuminJotai> juminJotaiList = new ArrayList<>();
//        juminJotaiList.add(JuminJotai.住民);
//        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
//        juminShubetsuList.add(JuminShubetsu.日本人);
//        juminShubetsuList.add(JuminShubetsu.外国人);
//        key.set住民状態(juminJotaiList);
//        key.set住民種別(juminShubetsuList);
//        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
//        return new KenkouKaruteRenkeiDataProcessParameter(
//                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return null;
    }

    /**
     * 健康かるて連携データ作成のMybatisParameter取得。
     *
     * @return KenkouKaruteRenkeiDataMybatisParameter
     */
    public KenkouKaruteRenkeiDataMybatisParameter toKenkouKaruteRenkeiDataMybatisParameter() {
        return KenkouKaruteRenkeiDataMybatisParameter.creatMybatisParameter(psmShikibetsuTaisho);
    }
}
