/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinsakaiiinguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideResult;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideMapperParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideManager;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 認定審査会委員ガイドDivの操作を行うクラスです。
 */
public class NinteiShinsakaiIinGuideHandler {

    private final NinteiShinsakaiIinGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定審査会委員ガイドDiv
     */
    public NinteiShinsakaiIinGuideHandler(NinteiShinsakaiIinGuideDiv div) {
        this.div = div;
    }

    /**
     * 性別ドロップダウンリストの設定です。
     *
     */
    public void set性別() {
        List<KeyValueDataSource> 性別リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(Seibetsu.男.getコード());
        dateSource.setValue(Seibetsu.男.get名称());
        性別リスト.add(dateSource);
        KeyValueDataSource dateSource2 = new KeyValueDataSource();
        dateSource2.setKey(Seibetsu.女.getコード());
        dateSource2.setValue(Seibetsu.女.get名称());
        性別リスト.add(dateSource2);
        div.getDdlSeibetsu().setDataSource(性別リスト);
    }

    /**
     * 審査会委員資格ドロップダウンリストの設定です。
     *
     */
    public void set審査会委員資格() {
        List<KeyValueDataSource> 審査会委員資格リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(Sikaku.医師.getコード());
        dateSource.setValue(Sikaku.医師.get名称());
        審査会委員資格リスト.add(dateSource);
        KeyValueDataSource dateSource1 = new KeyValueDataSource();
        dateSource1.setKey(Sikaku.歯科医師.getコード());
        dateSource1.setValue(Sikaku.歯科医師.get名称());
        審査会委員資格リスト.add(dateSource1);
        KeyValueDataSource dateSource2 = new KeyValueDataSource();
        dateSource2.setKey(Sikaku.薬剤師.getコード());
        dateSource2.setValue(Sikaku.薬剤師.get名称());
        審査会委員資格リスト.add(dateSource2);
        KeyValueDataSource dateSource3 = new KeyValueDataSource();
        dateSource3.setKey(Sikaku.保健師.getコード());
        dateSource3.setValue(Sikaku.保健師.get名称());
        審査会委員資格リスト.add(dateSource3);
        KeyValueDataSource dateSource4 = new KeyValueDataSource();
        dateSource4.setKey(Sikaku.助産師.getコード());
        dateSource4.setValue(Sikaku.助産師.get名称());
        審査会委員資格リスト.add(dateSource4);
        KeyValueDataSource dateSource5 = new KeyValueDataSource();
        dateSource5.setKey(Sikaku._洵_看護師.getコード());
        dateSource5.setValue(Sikaku._洵_看護師.get名称());
        審査会委員資格リスト.add(dateSource5);
        KeyValueDataSource dateSource6 = new KeyValueDataSource();
        dateSource6.setKey(Sikaku.理学療法士.getコード());
        dateSource6.setValue(Sikaku.理学療法士.get名称());
        審査会委員資格リスト.add(dateSource6);
        KeyValueDataSource dateSource7 = new KeyValueDataSource();
        dateSource7.setKey(Sikaku.作業療法士.getコード());
        dateSource7.setValue(Sikaku.作業療法士.get名称());
        審査会委員資格リスト.add(dateSource7);
        KeyValueDataSource dateSource8 = new KeyValueDataSource();
        dateSource8.setKey(Sikaku.社会福祉士.getコード());
        dateSource8.setValue(Sikaku.社会福祉士.get名称());
        審査会委員資格リスト.add(dateSource8);
        KeyValueDataSource dateSource9 = new KeyValueDataSource();
        dateSource9.setKey(Sikaku.介護福祉士.getコード());
        dateSource9.setValue(Sikaku.介護福祉士.get名称());
        審査会委員資格リスト.add(dateSource9);
        KeyValueDataSource dateSource10 = new KeyValueDataSource();
        dateSource10.setKey(Sikaku.ソーシャルワーカー.getコード());
        dateSource10.setValue(Sikaku.ソーシャルワーカー.get名称());
        審査会委員資格リスト.add(dateSource10);
        KeyValueDataSource dateSource11 = new KeyValueDataSource();
        dateSource11.setKey(Sikaku.福祉事務所現業員等.getコード());
        dateSource11.setValue(Sikaku.福祉事務所現業員等.get名称());
        審査会委員資格リスト.add(dateSource11);
        KeyValueDataSource dateSource12 = new KeyValueDataSource();
        dateSource12.setKey(Sikaku.ホームヘルパー.getコード());
        dateSource12.setValue(Sikaku.ホームヘルパー.get名称());
        審査会委員資格リスト.add(dateSource12);
        KeyValueDataSource dateSource13 = new KeyValueDataSource();
        dateSource13.setKey(Sikaku.介護職員.getコード());
        dateSource13.setValue(Sikaku.介護職員.get名称());
        審査会委員資格リスト.add(dateSource13);
        KeyValueDataSource dateSource14 = new KeyValueDataSource();
        dateSource14.setKey(Sikaku.その他福祉関係者.getコード());
        dateSource14.setValue(Sikaku.その他福祉関係者.get名称());
        審査会委員資格リスト.add(dateSource14);
        KeyValueDataSource dateSource15 = new KeyValueDataSource();
        dateSource15.setKey(Sikaku.行政関係者.getコード());
        dateSource15.setValue(Sikaku.行政関係者.get名称());
        審査会委員資格リスト.add(dateSource15);
        KeyValueDataSource dateSource16 = new KeyValueDataSource();
        dateSource16.setKey(Sikaku.その他.getコード());
        dateSource16.setValue(Sikaku.その他.get名称());
        審査会委員資格リスト.add(dateSource16);
        div.getDdlShinsainShikakuCode().setDataSource(審査会委員資格リスト);
    }

    /**
     * 医療機関情報ドロップダウンリストの設定です。
     *
     * @param 市町村コード 市町村コード
     */
    public void set医療機関(LasdecCode 市町村コード) {
        List<KeyValueDataSource> 医療機関リスト = createInstanceOfManager().get主治医医療機関情報(市町村コード).records();
        div.getKensakuJoken().getDdlIryoKikan().setDataSource(医療機関リスト);
    }

    /**
     * 介護事業者ドロップダウンリストの設定です。
     *
     * @param 市町村コード 市町村コード
     */
    public void set介護事業者(LasdecCode 市町村コード) {
        List<KeyValueDataSource> 介護事業者リスト = createInstanceOfManager().get認定調査委託先情報(市町村コード).records();
        div.getDdlKaigoJigyosha().setDataSource(介護事業者リスト);
    }

    /**
     * 介護事業者ドロップダウンリストの設定です。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void setその他事業者(ShoKisaiHokenshaNo 証記載保険者番号) {
        List<KeyValueDataSource> その他事業者リスト = createInstanceOfManager().getその他機関情報(証記載保険者番号).records();
        div.getDdlSonotaJigyosha().setDataSource(その他事業者リスト);
    }

    /**
     * 審査会委員一覧情報の設定です。
     *
     * @param parameter 審査会委員一覧情報のMyBatis用パラメータ
     */
    public void 審査会委員一覧情報の設定(NinteiShinsakaiIinGuideMapperParameter parameter) {
        List<NinteiShinsakaiIinGuideResult> 審査会委員一覧リスト = createInstanceOfManager().get審査会委員一覧情報(parameter).records();
        List<dgShinsakaiIinIchiran_Row> 検索一覧データ = new ArrayList<>();
        for (NinteiShinsakaiIinGuideResult result : 審査会委員一覧リスト) {
            dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row();
            row.setCode(result.getコード());
            row.setShinsakaiIinName(result.get審査会委員名称().value());
            row.setShinsakaiIinKanaName(result.get審査会委員名カナ().value());
            row.setSeibetsu(result.get性別());
            row.setShinsakaiIinShikaku(result.get審査会委員資格().value());
            検索一覧データ.add(row);
        }
        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(検索一覧データ);
    }

    private NinteiShinsakaiIinGuideManager createInstanceOfManager() {
        return NinteiShinsakaiIinGuideManager.createInstance();
    }
}
