/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsahoshushokai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiran;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsahoshuichiran.ShinsaHoshuIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会委員報酬照会のデータを検索クラスです。
 *
 * @reamsid_L DBE-1920-010 zhaoyao
 */
public class ShinsakauIinHoshuShokaiFindler {

    private final MapperProvider mapperProvider;
    private static final RString 欠 = new RString("欠");
    private static final RString 長 = new RString("長");
    private static final RString 出 = new RString("出");
    private static final RString 副 = new RString("副");
    private static final RString 欠_対応 = new RString("×");
    private static final RString 長_対応 = new RString("○");
    private static final RString 出_対応 = new RString("◎");
    private static final RString 副_対応 = new RString("-");
    private int 出席回数;

    /**
     * コンストラクタです。
     */
    ShinsakauIinHoshuShokaiFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    ShinsakauIinHoshuShokaiFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakauIinHoshuShokaiFindler}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakauIinHoshuShokaiFindler}のインスタンス
     *
     */
    public static ShinsakauIinHoshuShokaiFindler createInstance() {
        return InstanceProvider.create(ShinsakauIinHoshuShokaiFindler.class);
    }

    /**
     * 審査会委員報酬照会を取得します。
     *
     * @param paramter 検索用パラメータです。
     * @return SearchResult<ShinsaHoshuIchiran>
     */
    public SearchResult<ShinsaHoshuIchiran> get審査会委員報酬照会(ShinsaHoshuIchiranMybitisParamter paramter) {

        IShinsaHoshuIchiranMapper mapper = mapperProvider.create(IShinsaHoshuIchiranMapper.class);

        List<ShinsaHoshuIchiranRelateEntity> 合計額リスト = mapper.get合計額(ShinsaHoshuIchiranMybitisParamter.createParamter(paramter.get審査会開催年月()));
        List<ShinsaHoshuIchiranRelateEntity> 出席状況リスト = mapper.get出席状況(paramter.get審査会開催年月());

        Iterator<ShinsaHoshuIchiranRelateEntity> 合計額ループ = 合計額リスト.iterator();

        ShinsaHoshuIchiranRelateEntity 審査会委員報酬照会 = new ShinsaHoshuIchiranRelateEntity();
        List<ShinsaHoshuIchiran> 審査会委員報酬照会List = new ArrayList<>();

        while (合計額ループ.hasNext()) {
            ShinsaHoshuIchiranRelateEntity 合計額 = 合計額ループ.next();

            for (ShinsaHoshuIchiranRelateEntity 出席状況 : 出席状況リスト) {

                if (合計額.get合議体番号() == (出席状況.get合議体番号())
                        && 合計額.get介護認定審査会委員コード().equals(出席状況.get介護認定審査会委員コード())) {
                    出席回数 = 0;
                    審査会委員報酬照会.set合議体番号(合計額.get合議体番号());
                    審査会委員報酬照会.set介護認定審査会委員コード(合計額.get介護認定審査会委員コード());
                    審査会委員報酬照会.set介護認定審査会委員氏名(出席状況.get介護認定審査会委員氏名());
                    審査会委員報酬照会.set報酬合計(合計額.get報酬合計());
                    審査会委員報酬照会.set報酬総額(合計額.get報酬総額());
                    審査会委員報酬照会.set税額控除(合計額.get税額控除());
                    審査会委員報酬照会.set出席状況_1日(set出席状況(出席状況.get出席状況_1日()));
                    this.get出席回数(出席状況.get出席状況_1日());
                    審査会委員報酬照会.set出席状況_2日(set出席状況(出席状況.get出席状況_2日()));
                    this.get出席回数(出席状況.get出席状況_2日());
                    審査会委員報酬照会.set出席状況_3日(set出席状況(出席状況.get出席状況_3日()));
                    this.get出席回数(出席状況.get出席状況_3日());
                    審査会委員報酬照会.set出席状況_4日(set出席状況(出席状況.get出席状況_4日()));
                    this.get出席回数(出席状況.get出席状況_4日());
                    審査会委員報酬照会.set出席状況_5日(set出席状況(出席状況.get出席状況_5日()));
                    this.get出席回数(出席状況.get出席状況_5日());
                    審査会委員報酬照会.set出席状況_6日(set出席状況(出席状況.get出席状況_6日()));
                    this.get出席回数(出席状況.get出席状況_6日());
                    審査会委員報酬照会.set出席状況_7日(set出席状況(出席状況.get出席状況_7日()));
                    this.get出席回数(出席状況.get出席状況_7日());
                    審査会委員報酬照会.set出席状況_8日(set出席状況(出席状況.get出席状況_8日()));
                    this.get出席回数(出席状況.get出席状況_8日());
                    審査会委員報酬照会.set出席状況_9日(set出席状況(出席状況.get出席状況_9日()));
                    this.get出席回数(出席状況.get出席状況_9日());
                    審査会委員報酬照会.set出席状況_10日(set出席状況(出席状況.get出席状況_10日()));
                    this.get出席回数(出席状況.get出席状況_10日());
                    審査会委員報酬照会.set出席状況_11日(set出席状況(出席状況.get出席状況_11日()));
                    this.get出席回数(出席状況.get出席状況_11日());
                    審査会委員報酬照会.set出席状況_12日(set出席状況(出席状況.get出席状況_12日()));
                    this.get出席回数(出席状況.get出席状況_12日());
                    審査会委員報酬照会.set出席状況_13日(set出席状況(出席状況.get出席状況_13日()));
                    this.get出席回数(出席状況.get出席状況_13日());
                    審査会委員報酬照会.set出席状況_14日(set出席状況(出席状況.get出席状況_14日()));
                    this.get出席回数(出席状況.get出席状況_14日());
                    審査会委員報酬照会.set出席状況_15日(set出席状況(出席状況.get出席状況_15日()));
                    this.get出席回数(出席状況.get出席状況_15日());
                    審査会委員報酬照会.set出席状況_16日(set出席状況(出席状況.get出席状況_16日()));
                    this.get出席回数(出席状況.get出席状況_16日());
                    審査会委員報酬照会.set出席状況_17日(set出席状況(出席状況.get出席状況_17日()));
                    this.get出席回数(出席状況.get出席状況_17日());
                    審査会委員報酬照会.set出席状況_18日(set出席状況(出席状況.get出席状況_18日()));
                    this.get出席回数(出席状況.get出席状況_18日());
                    審査会委員報酬照会.set出席状況_19日(set出席状況(出席状況.get出席状況_19日()));
                    this.get出席回数(出席状況.get出席状況_19日());
                    審査会委員報酬照会.set出席状況_20日(set出席状況(出席状況.get出席状況_20日()));
                    this.get出席回数(出席状況.get出席状況_20日());
                    審査会委員報酬照会.set出席状況_21日(set出席状況(出席状況.get出席状況_21日()));
                    this.get出席回数(出席状況.get出席状況_21日());
                    審査会委員報酬照会.set出席状況_22日(set出席状況(出席状況.get出席状況_22日()));
                    this.get出席回数(出席状況.get出席状況_22日());
                    審査会委員報酬照会.set出席状況_23日(set出席状況(出席状況.get出席状況_23日()));
                    this.get出席回数(出席状況.get出席状況_23日());
                    審査会委員報酬照会.set出席状況_24日(set出席状況(出席状況.get出席状況_24日()));
                    this.get出席回数(出席状況.get出席状況_24日());
                    審査会委員報酬照会.set出席状況_25日(set出席状況(出席状況.get出席状況_25日()));
                    this.get出席回数(出席状況.get出席状況_25日());
                    審査会委員報酬照会.set出席状況_26日(set出席状況(出席状況.get出席状況_26日()));
                    this.get出席回数(出席状況.get出席状況_26日());
                    審査会委員報酬照会.set出席状況_27日(set出席状況(出席状況.get出席状況_27日()));
                    this.get出席回数(出席状況.get出席状況_27日());
                    審査会委員報酬照会.set出席状況_28日(set出席状況(出席状況.get出席状況_28日()));
                    this.get出席回数(出席状況.get出席状況_28日());
                    審査会委員報酬照会.set出席状況_29日(set出席状況(出席状況.get出席状況_29日()));
                    this.get出席回数(出席状況.get出席状況_29日());
                    審査会委員報酬照会.set出席状況_30日(set出席状況(出席状況.get出席状況_30日()));
                    this.get出席回数(出席状況.get出席状況_30日());
                    審査会委員報酬照会.set出席状況_31日(set出席状況(出席状況.get出席状況_31日()));
                    this.get出席回数(出席状況.get出席状況_31日());
                    審査会委員報酬照会.set出席回数(出席回数);

                    審査会委員報酬照会List.add(new ShinsaHoshuIchiran(審査会委員報酬照会));
                    審査会委員報酬照会 = new ShinsaHoshuIchiranRelateEntity();
                }
            }
        }
        return SearchResult.of(審査会委員報酬照会List, 0, false);
    }

    /**
     * 出席回数の取得
     *
     * @param 出席状況 原出席状況
     */
    public void get出席回数(RString 出席状況) {
        if (ShinsakauIinHoshuShokaiFindler.長.equals(出席状況)
                || ShinsakauIinHoshuShokaiFindler.副.equals(出席状況)
                || ShinsakauIinHoshuShokaiFindler.出.equals(出席状況)) {
            出席回数++;
        }
    }

    /**
     * 出席状況の設定
     *
     * @param 出席状況 原出席状況
     * @return set出席状況
     */
    public RString set出席状況(RString 出席状況) {

        if (ShinsakauIinHoshuShokaiFindler.長.equals(出席状況)) {
            出席状況 = ShinsakauIinHoshuShokaiFindler.長_対応;
        }
        if (ShinsakauIinHoshuShokaiFindler.副.equals(出席状況)) {
            出席状況 = ShinsakauIinHoshuShokaiFindler.副_対応;
        }
        if (ShinsakauIinHoshuShokaiFindler.出.equals(出席状況)) {
            出席状況 = ShinsakauIinHoshuShokaiFindler.出_対応;
        }
        if (ShinsakauIinHoshuShokaiFindler.欠.equals(出席状況)) {
            出席状況 = ShinsakauIinHoshuShokaiFindler.欠_対応;
        }
        return 出席状況;
    }
}
