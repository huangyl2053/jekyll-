/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaijizenshinsakekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran.JizenShinsakaiShiryo;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenShinsakekkaIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsakaiShiryoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaijizenshinsakekkaichiran.IShinsakaiJIzenShinsakekkaIchiranMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会委員事前審査結果登録のデータを検索クラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenShinsakekkaIchiranFinder {

    private final MapperProvider mapperProvider;
    private static final int ZERO = 0;
    private static final int ITI = 1;
    private static final int NI = 2;
    private static final int SAN = 3;
    private static final int YON = 4;

    /**
     * コンストラクタです。
     */
    ShinsakaiJIzenShinsakekkaIchiranFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    ShinsakaiJIzenShinsakekkaIchiranFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiJIzenShinsakekkaIchiranFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiJIzenShinsakekkaIchiranFinder}のインスタンス
     */
    public static ShinsakaiJIzenShinsakekkaIchiranFinder createInstance() {
        return InstanceProvider.create(ShinsakaiJIzenShinsakekkaIchiranFinder.class);
    }

    /**
     * 事前審査会用結果を取得します。
     *
     * @param paramter 検索用パラメータです。
     * @return SearchResult<JizenShinsakaiShiryo>
     */
    public SearchResult<JizenShinsakaiShiryo> get事前審査会用結果(RString paramter) {
        IShinsakaiJIzenShinsakekkaIchiranMapper mapper = mapperProvider.create(IShinsakaiJIzenShinsakekkaIchiranMapper.class);

        List<JizenShinsakaiShiryo> 事前審査会用結果List = new ArrayList<>();

        JizenShinsakaiShiryoRelateEntity 事前審査会用結果 = mapper.get事前審査会用結果(
                ShinsakaiJIzenShinsakekkaIchiranMybitisParamter.createParamter(paramter));

        事前審査会用結果List.add(new JizenShinsakaiShiryo(事前審査会用結果));
        return SearchResult.of(事前審査会用結果List, 0, false);
    }

    /**
     * 事前審査結果を取得します。
     *
     * @param paramter 検索用パラメータです。
     * @return SearchResult<JizenShinsaKekkaJokyo>
     */
    public SearchResult<JizenShinsaKekkaJokyo> get事前審査結果(RString paramter) {
        IShinsakaiJIzenShinsakekkaIchiranMapper mapper = mapperProvider.create(IShinsakaiJIzenShinsakekkaIchiranMapper.class);
        JizenShinsaKekkaJokyo 事前審査結果状況 = new JizenShinsaKekkaJokyo();
        List<JizenShinsaKekkaJokyo> 事前審査結果List = new ArrayList();
        List<JizenShinsaKekkaRelateEntity> 審査順リスト = mapper.get審査順(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter.createParamter(paramter));
        List<JizenShinsaKekkaRelateEntity> 審査結果リスト = mapper.get審査結果(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter.createParamter(paramter));
        List<JizenShinsaKekkaRelateEntity> 審査員名リスト = mapper.get審査員名(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter.createParamter(paramter));
        事前審査結果状況.setShinsakaiOrder(new RString("審査会審査順"));
        try {
            事前審査結果状況.setShisain1(審査員名リスト.get(ZERO).getShinsakaiIinShimei());
        } catch (Exception e) {
            事前審査結果状況.setShisain1(RString.EMPTY);
        }
        try {
            事前審査結果状況.setShisain2(審査員名リスト.get(ITI).getShinsakaiIinShimei());
        } catch (Exception e) {
            事前審査結果状況.setShisain2(RString.EMPTY);
        }
        try {
            事前審査結果状況.setShisain3(審査員名リスト.get(NI).getShinsakaiIinShimei());
        } catch (Exception e) {
            事前審査結果状況.setShisain3(RString.EMPTY);
        }
        try {
            事前審査結果状況.setShisain4(審査員名リスト.get(SAN).getShinsakaiIinShimei());
        } catch (Exception e) {
            事前審査結果状況.setShisain4(RString.EMPTY);
        }
        try {
            事前審査結果状況.setShisain5(審査員名リスト.get(YON).getShinsakaiIinShimei());
        } catch (Exception e) {
            事前審査結果状況.setShisain5(RString.EMPTY);
        }
        事前審査結果List.add(事前審査結果状況);
        for (JizenShinsaKekkaRelateEntity 審査順 : 審査順リスト) {
            JizenShinsaKekkaJokyo 審査順設定 = new JizenShinsaKekkaJokyo();
            審査順設定.setShinsakaiOrder(new RString(審査順.getShinsakaiOrder()));
            事前審査結果List.add(審査順設定);
        }
        事前審査結果List = set事前審査結果(事前審査結果List, 審査結果リスト, 審査員名リスト);
        return SearchResult.of(事前審査結果List, 0, false);
    }

    /**
     * 審査員コードを取得します。
     *
     * @param paramter 検索用パラメータです。
     * @return SearchResult<RString>
     */
    public SearchResult<RString> get審査員(RString paramter) {
        IShinsakaiJIzenShinsakekkaIchiranMapper mapper = mapperProvider.create(IShinsakaiJIzenShinsakekkaIchiranMapper.class);
        List<JizenShinsaKekkaRelateEntity> 審査員名 = mapper.get審査員名(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter
                .createParamter(paramter));
        List<RString> 審査員コードリスト = new ArrayList();
        for (JizenShinsaKekkaRelateEntity 審査員 : 審査員名) {
            RString 審査員コード = 審査員.getShinsakaiIinCode();
            審査員コードリスト.add(審査員コード);
        }
        return SearchResult.of(審査員コードリスト, 0, false);
    }

    private List<JizenShinsaKekkaJokyo> set事前審査結果(List<JizenShinsaKekkaJokyo> 事前審査結果List, List<JizenShinsaKekkaRelateEntity> 審査結果リスト,
            List<JizenShinsaKekkaRelateEntity> 審査員名リスト) {
        for (int i = 0; i < 事前審査結果List.size(); i++) {
            for (JizenShinsaKekkaRelateEntity 審査結果 : 審査結果リスト) {
                JizenShinsaKekkaJokyo 事前審査結果 = 事前審査結果List.get(i);
                try {
                    if (事前審査結果.getShinsakaiOrder().equals(new RString(審査結果.getShinsakaiOrder()))
                            && 審査員名リスト.get(ZERO).getShinsakaiIinCode().equals(審査結果.getShinsakaiIinCode())) {
                        事前審査結果.setShisain1(審査結果.getNijiHanteiKekkaCode());
                    }
                } catch (Exception e) {
                    事前審査結果.setShisain1(RString.EMPTY);
                }
                try {
                    if (事前審査結果.getShinsakaiOrder().equals(new RString(審査結果.getShinsakaiOrder()))
                            && 審査員名リスト.get(ITI).getShinsakaiIinCode().equals(審査結果.getShinsakaiIinCode())) {
                        事前審査結果.setShisain2(審査結果.getNijiHanteiKekkaCode());
                    }
                } catch (Exception e) {
                    事前審査結果.setShisain2(RString.EMPTY);
                }
                try {
                    if (事前審査結果.getShinsakaiOrder().equals(new RString(審査結果.getShinsakaiOrder()))
                            && 審査員名リスト.get(NI).getShinsakaiIinCode().equals(審査結果.getShinsakaiIinCode())) {
                        事前審査結果.setShisain3(審査結果.getNijiHanteiKekkaCode());
                    }
                } catch (Exception e) {
                    事前審査結果.setShisain3(RString.EMPTY);
                }
                try {
                    if (事前審査結果.getShinsakaiOrder().equals(new RString(審査結果.getShinsakaiOrder()))
                            && 審査員名リスト.get(SAN).getShinsakaiIinCode().equals(審査結果.getShinsakaiIinCode())) {
                        事前審査結果.setShisain4(審査結果.getNijiHanteiKekkaCode());
                    }
                } catch (Exception e) {
                    事前審査結果.setShisain4(RString.EMPTY);
                }
                try {
                    if (事前審査結果.getShinsakaiOrder().equals(new RString(審査結果.getShinsakaiOrder()))
                            && 審査員名リスト.get(YON).getShinsakaiIinCode().equals(審査結果.getShinsakaiIinCode())) {
                        事前審査結果.setShisain5(審査結果.getNijiHanteiKekkaCode());
                    }
                } catch (Exception e) {
                    事前審査結果.setShisain5(RString.EMPTY);
                }
            }
        }
        return 事前審査結果List;
    }
}
