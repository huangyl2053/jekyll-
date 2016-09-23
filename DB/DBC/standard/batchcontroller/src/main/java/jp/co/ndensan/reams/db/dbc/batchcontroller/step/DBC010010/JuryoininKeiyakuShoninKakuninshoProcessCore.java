/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200013.JuryoIninShoninKakuninshoIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc010010.JuryoininKeiyakuShoninKakuninshoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010.BusinessEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100029.JyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * キーブレイク判定及び処理ロジッククラスです。
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
public class JuryoininKeiyakuShoninKakuninshoProcessCore {

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
    private int 利用者向けPAGE;
    private int 事業者用PAGE;
    private List<RString> breakPage;
    private List<RString> breakItemIds;

    /**
     * コンストラクタです。
     *
     * @param 出力順 出力順
     */
    public JuryoininKeiyakuShoninKakuninshoProcessCore(IOutputOrder 出力順) {
        this.出力順 = 出力順;
        initialize();
    }

    /**
     * 改ページ判断です。
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

    private void initialize() {
        改頁 = false;
        利用者向けPAGE = 0;
        事業者用PAGE = 0;
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

    /**
     * キーブレイク判定と値の設定です。
     *
     * @param businessEntity BusinessEntity
     * @param 利用者向け認証者情報 NinshoshaSource
     * @param proParameter JuryoininKeiyakuShoninKakuninshoProcessParameter
     * @return JyuryoItakuKeiyakuKakuninShoEntity
     */
    public JyuryoItakuKeiyakuKakuninShoEntity edit利用者向けEntity(BusinessEntity businessEntity, NinshoshaSource 利用者向け認証者情報,
            JuryoininKeiyakuShoninKakuninshoProcessParameter proParameter) {
        利用者向けPAGE++;
        JyuryoItakuKeiyakuKakuninShoEntity 利用者向けEntity = businessEntity.get利用者向けEntity();
        利用者向けEntity.setページ(new RString(利用者向けPAGE));
        利用者向けEntity.set文書番号(proParameter.get文書番号());
        利用者向けEntity.set発行日(利用者向け認証者情報.hakkoYMD);
        利用者向けEntity.set電子公印(利用者向け認証者情報.denshiKoin);
        利用者向けEntity.set認証者役職名(利用者向け認証者情報.ninshoshaYakushokuMei);
        利用者向けEntity.set認証者役職名1(利用者向け認証者情報.ninshoshaYakushokuMei1);
        利用者向けEntity.set公印文字列(利用者向け認証者情報.koinMojiretsu);
        利用者向けEntity.set認証者役職名2(利用者向け認証者情報.ninshoshaYakushokuMei2);
        利用者向けEntity.set認証者氏名掛けない(利用者向け認証者情報.ninshoshaShimeiKakenai);
        利用者向けEntity.set認証者氏名掛ける(利用者向け認証者情報.ninshoshaShimeiKakeru);
        利用者向けEntity.set公印省略(利用者向け認証者情報.koinShoryaku);
        利用者向けEntity.setタイトル(proParameter.get利用者向けタイトル());
        利用者向けEntity.set通知文1(proParameter.get利用者向け通知文1());
        利用者向けEntity.set通知文2(proParameter.get利用者向け通知文2());
        利用者向けEntity.set改頁1(改頁1);
        利用者向けEntity.set改頁2(改頁2);
        利用者向けEntity.set改頁3(改頁3);
        利用者向けEntity.set改頁4(改頁4);
        利用者向けEntity.set改頁5(改頁5);
        利用者向けEntity.set出力順1(出力順1);
        利用者向けEntity.set出力順2(出力順2);
        利用者向けEntity.set出力順3(出力順3);
        利用者向けEntity.set出力順4(出力順4);
        利用者向けEntity.set出力順5(出力順5);
        利用者向けEntity.set市町村コード(proParameter.get市町村コード().value());
        利用者向けEntity.set市町村名称(proParameter.get市町村名称());
        利用者向けEntity.set作成日時(proParameter.get処理日時());
        return 利用者向けEntity;
    }

    /**
     * キーブレイク判定と値の設定です。
     *
     * @param businessEntity BusinessEntity
     * @param 事業者用認証者情報 事業者用認証者情報
     * @param proParameter JuryoininKeiyakuShoninKakuninshoProcessParameter
     * @return JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity
     */
    public JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity edit事業者用Entity(BusinessEntity businessEntity, NinshoshaSource 事業者用認証者情報,
            JuryoininKeiyakuShoninKakuninshoProcessParameter proParameter) {
        事業者用PAGE++;
        JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 事業者用Entity = businessEntity.get事業者用Entity();
        事業者用Entity.setページ(new RString(事業者用PAGE));
        事業者用Entity.set文書番号(proParameter.get文書番号());
        事業者用Entity.set発行日(事業者用認証者情報.hakkoYMD);
        事業者用Entity.set電子公印(事業者用認証者情報.denshiKoin);
        事業者用Entity.set認証者役職名(事業者用認証者情報.ninshoshaYakushokuMei);
        事業者用Entity.set認証者役職名1(事業者用認証者情報.ninshoshaYakushokuMei1);
        事業者用Entity.set公印文字列(事業者用認証者情報.koinMojiretsu);
        事業者用Entity.set認証者役職名2(事業者用認証者情報.ninshoshaYakushokuMei2);
        事業者用Entity.set認証者氏名掛けない(事業者用認証者情報.ninshoshaShimeiKakenai);
        事業者用Entity.set認証者氏名掛ける(事業者用認証者情報.ninshoshaShimeiKakeru);
        事業者用Entity.set公印省略(事業者用認証者情報.koinShoryaku);
        事業者用Entity.setタイトル(proParameter.get事業者用タイトル());
        事業者用Entity.set通知文1(proParameter.get事業者用通知文1());
        事業者用Entity.set通知文2(proParameter.get事業者用通知文2());
        事業者用Entity.set改頁1(改頁1);
        事業者用Entity.set改頁2(改頁2);
        事業者用Entity.set改頁3(改頁3);
        事業者用Entity.set改頁4(改頁4);
        事業者用Entity.set改頁5(改頁5);
        事業者用Entity.set出力順1(出力順1);
        事業者用Entity.set出力順2(出力順2);
        事業者用Entity.set出力順3(出力順3);
        事業者用Entity.set出力順4(出力順4);
        事業者用Entity.set出力順5(出力順5);
        事業者用Entity.set市町村コード(proParameter.get市町村コード().value());
        事業者用Entity.set市町村名称(proParameter.get市町村名称());
        事業者用Entity.set作成日時(proParameter.get処理日時());
        return 事業者用Entity;
    }

    /**
     * キーブレイク判定と値の設定です。
     *
     * @param entity JuryoIninShoninKakuninshoIchiranEntity
     * @param proParameter JuryoininKeiyakuShoninKakuninshoProcessParameter
     * @return JuryoIninShoninKakuninshoIchiranParameter
     */
    public JuryoIninShoninKakuninshoIchiranParameter edit一覧表Entity(JuryoIninShoninKakuninshoIchiranEntity entity,
            JuryoininKeiyakuShoninKakuninshoProcessParameter proParameter) {
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
        一覧表Parameter.set市町村コード(proParameter.get市町村コード().value());
        一覧表Parameter.set市町村名称(proParameter.get市町村名称());
        一覧表Parameter.set作成日時(proParameter.get処理日時());
        return 一覧表Parameter;
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
        出力順1 = sort.get(0);
        出力順2 = sort.get(NUMBER_ONE);
        出力順3 = sort.get(NUMBER_TWO);
        出力順4 = sort.get(NUMBER_THREE);
        出力順5 = sort.get(NUMBER_FOUR);
        改頁1 = breakPage.get(0);
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
