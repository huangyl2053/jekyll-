/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200013.JuryoIninShoninKakuninshoIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehijuryoininkeiyakushoninkakuninsho.KogakuServicehiJuryoininProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * キーブレイク判定及び処理ロジッククラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
public class KogakuServiceHiJyuryoItakuKeiyakuKakuninShoProcessCore {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_FOUR = 4;
    private static final int NUMBER_FIVE = 5;
    private final IOutputOrder 出力順;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private boolean 改頁;
    private List<RString> breakPage;
    private List<RString> breakItemIds;

    /**
     * コンストラクタです。
     *
     * @param 出力順 IOutputOrder
     */
    public KogakuServiceHiJyuryoItakuKeiyakuKakuninShoProcessCore(IOutputOrder 出力順) {
        this.出力順 = 出力順;
        initialize();
    }

    /**
     * 改ページの判断です。
     *
     * @return 改頁 boolean
     */
    public boolean is改頁() {
        return 改頁;
    }

    /**
     * 改ページ判断です。
     *
     * @return List<RString> 改頁項
     */
    public List<RString> 改頁項() {
        return breakItemIds;
    }

    /**
     * 介護保険高額Entityを共通項目に設定します。
     *
     * @param entity KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity
     * @param processParameter
     * KogakuServicehiJuryoininKeiyakuShoninKakuninshoProcessParameter
     * @param 確認書認証者情報 NinshoshaSource
     * @param 通知文1 RString
     * @param 通知文2 RString
     * @return KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity
     */
    public KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity edit確認書Entity(KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity entity,
            KogakuServicehiJuryoininProcessParameter processParameter, NinshoshaSource 確認書認証者情報,
            RString 通知文1, RString 通知文2) {
        entity.set文書番号(processParameter.get文書番号());
        entity.set発行日(確認書認証者情報.hakkoYMD);
        entity.set電子公印(確認書認証者情報.denshiKoin);
        entity.set認証者役職名(確認書認証者情報.ninshoshaYakushokuMei);
        entity.set認証者役職名1(確認書認証者情報.ninshoshaYakushokuMei1);
        entity.set公印文字列(確認書認証者情報.koinMojiretsu);
        entity.set認証者役職名2(確認書認証者情報.ninshoshaYakushokuMei2);
        entity.set認証者氏名掛けない(確認書認証者情報.ninshoshaShimeiKakenai);
        entity.set認証者氏名掛ける(確認書認証者情報.ninshoshaShimeiKakeru);
        entity.set公印省略(確認書認証者情報.koinShoryaku);
        entity.set通知文1(通知文1);
        entity.set通知文2(通知文2);
        return entity;
    }

    /**
     * 一覧表帳票のパラメータを設定します。
     *
     * @param entity JuryoIninShoninKakuninshoIchiranEntity
     * @param processParameter
     * KogakuServicehiJuryoininKeiyakuShoninKakuninshoProcessParameter
     * @param 導入団体クラス Association
     * @return JuryoIninShoninKakuninshoIchiranParameter
     */
    public JuryoIninShoninKakuninshoIchiranParameter edit一覧表Entity(JuryoIninShoninKakuninshoIchiranEntity entity,
            KogakuServicehiJuryoininProcessParameter processParameter, Association 導入団体クラス) {
        JuryoIninShoninKakuninshoIchiranParameter 一覧表Parameter = new JuryoIninShoninKakuninshoIchiranParameter();
        一覧表Parameter.set受領委任契約承認確認書発行一覧表(entity);
        一覧表Parameter.set改頁1(改頁1);
        一覧表Parameter.set改頁2(改頁2);
        一覧表Parameter.set改頁3(改頁3);
        一覧表Parameter.set改頁4(改頁4);
        一覧表Parameter.set改頁5(改頁5);
        一覧表Parameter.set出力順1(出力順1);
        一覧表Parameter.set出力順2(出力順2);
        一覧表Parameter.set出力順3(出力順3);
        一覧表Parameter.set出力順4(出力順4);
        一覧表Parameter.set出力順5(出力順5);
        一覧表Parameter.set市町村コード(processParameter.get市町村コード().value());
        一覧表Parameter.set市町村名称(導入団体クラス.get市町村名());
        一覧表Parameter.set作成日時(processParameter.get処理日時());
        return 一覧表Parameter;
    }

    private void initialize() {
        改頁 = false;
        breakItemIds = new ArrayList<>();
        出力順1 = RString.EMPTY;
        出力順2 = RString.EMPTY;
        出力順3 = RString.EMPTY;
        出力順4 = RString.EMPTY;
        出力順5 = RString.EMPTY;
        改頁1 = RString.EMPTY;
        改頁2 = RString.EMPTY;
        改頁3 = RString.EMPTY;
        改頁4 = RString.EMPTY;
        改頁5 = RString.EMPTY;
        set出力順改頁();
    }

    private void set出力順改頁() {
        if (出力順 == null || 出力順.get設定項目リスト() == null || 出力順.get設定項目リスト().isEmpty()) {
            return;
        }
        List<RString> sort = new ArrayList<>();
        RString displayName;
        breakPage = new ArrayList<>();
        for (ISetSortItem item : 出力順.get設定項目リスト()) {
            displayName = item.get項目名();
            if (displayName != null) {
                if (item.is改頁項目()) {
                    breakPage.add(displayName);
                    breakItemIds.add(item.get項目ID());
                    改頁 = true;
                }
                sort.add(displayName);
            }
        }
        addItem(sort);
        addItem(breakPage);
        出力順1 = sort.get(NUMBER_ZERO);
        出力順2 = sort.get(NUMBER_ONE);
        出力順3 = sort.get(NUMBER_TWO);
        出力順4 = sort.get(NUMBER_THREE);
        出力順5 = sort.get(NUMBER_FOUR);
        改頁1 = breakPage.get(NUMBER_ZERO);
        改頁2 = breakPage.get(NUMBER_ONE);
        改頁3 = breakPage.get(NUMBER_TWO);
        改頁4 = breakPage.get(NUMBER_THREE);
        改頁5 = breakPage.get(NUMBER_FOUR);
    }

    private void addItem(List<RString> list) {
        int num = list.size();
        if (num < NUMBER_FIVE) {
            num = NUMBER_FIVE - num;
            for (int i = 0; i < num; i++) {
                list.add(RString.EMPTY);
            }
        }
    }

}
