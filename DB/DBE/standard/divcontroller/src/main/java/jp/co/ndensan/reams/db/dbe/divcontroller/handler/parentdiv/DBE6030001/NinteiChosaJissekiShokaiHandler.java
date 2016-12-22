/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosahyojissekiichiran.ChosahyoJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601002.DBE601002_NinteichosaJissekiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyojissekiichiran.ChosahyoJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001.NinteiChosaJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001.dgNinteiChosaJisseki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 認定調査実績照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1691-010 dangjingjing
 */
public class NinteiChosaJissekiShokaiHandler {

    private static final RString KEY_基準日_初期値 = new RString("3");
    private final NinteiChosaJissekiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiChosaJissekiShokaiHandler(NinteiChosaJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 条件をクリアする」ボタンを押します。
     */
    public void onClick_BtnKensakuClear() {
        div.getRadKijunbi().setSelectedValue(KEY_基準日_初期値);
        div.getChosaJisshibi().getTxtChosaJisshibi().clearFromValue();
        div.getChosaJisshibi().getTxtChosaJisshibi().clearToValue();
        div.getChosaJisshibi().getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param searchResult 認定調査実績照会
     * @return 該当データがない場合はメッセージを返します。該当データがある場合は{@code null}を返します。
     */
    public Message onClick_btnKensaku(SearchResult<ChosahyoJissekiIchiran> searchResult) {

        List<ChosahyoJissekiIchiran> chosahyoJissekiIchiransList = searchResult.records();
        if (chosahyoJissekiIchiransList.isEmpty()) {
            return UrInformationMessages.該当データなし.getMessage();
        }
        setRecords(chosahyoJissekiIchiransList);
        if (searchResult.exceedsLimit()) {
            div.getDgNinteiChosaJisseki().getGridSetting().setLimitRowCount(chosahyoJissekiIchiransList.size());
            div.getDgNinteiChosaJisseki().getGridSetting().setSelectedRowCount(searchResult.totalCount());
        } else {
            div.getDgNinteiChosaJisseki().getGridSetting().setLimitRowCount(div.getTxtMaxKensu().getValue().intValue());
            div.getDgNinteiChosaJisseki().getGridSetting().setSelectedRowCount(searchResult.totalCount());
        }
        return null;
    }

    private void setRecords(List<ChosahyoJissekiIchiran> chosahyoJissekiIchiransList) {
        List<dgNinteiChosaJisseki_Row> rowList = new ArrayList<>();
        for (ChosahyoJissekiIchiran data : chosahyoJissekiIchiransList) {
            AccessLogger.log(AccessLogType.照会, toPersonalData(data.get申請書管理番号()));
            dgNinteiChosaJisseki_Row row = new dgNinteiChosaJisseki_Row(
                    get保険者(data),
                    data.get調査委託先コード(),
                    data.get事業者名称(),
                    data.get調査員コード(),
                    data.get調査員氏名(),
                    data.get被保険者番号(),
                    data.get被保険者氏名(),
                    dataFormat(data.get認定調査依頼年月日()),
                    dataFormat(data.get認定調査実施年月日()),
                    dataFormat(data.get認定調査入手年月日()),
                    ChosaKubun.toValue(data.get認定調査区分コード()).get名称(),
                    NinteiChousaIraiKubunCode.toValue(data.get認定調査依頼区分コード()).get名称(),
                    data.get申請書管理番号(),
                    data.get認定調査依頼履歴番号()
            );
            rowList.add(row);
        }
        div.getDgNinteiChosaJisseki().setDataSource(rowList);
    }

    private RString get保険者(ChosahyoJissekiIchiran data) {
        return nullToEmpty(data.get証記載保険者番号()).concat(RString.HALF_SPACE).concat(nullToEmpty(data.get市町村名称()));
    }

    private RString nullToEmpty(RString str) {
        return str == null ? RString.EMPTY : str;
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInformation = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInformation);
    }

    /**
     * バッチパラメータを作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @return バッチパラメータ
     */
    public DBE601002_NinteichosaJissekiParameter createBatchParam(RString 帳票出力区分) {
        DBE601002_NinteichosaJissekiParameter param = new DBE601002_NinteichosaJissekiParameter();
        List<ChosahyoJissekiIchiranKey> keyJoho = new ArrayList<>();
        for (dgNinteiChosaJisseki_Row row : div.getDgNinteiChosaJisseki().getDataSource()) {
            if (row.getSelected()) {
                ChosahyoJissekiIchiranKey key = new ChosahyoJissekiIchiranKey();
                key.setNinteichosaItakusakiCode(row.getCode());
                key.setNinteichosainCode(row.getNinteichosainCode());
                key.setShinseishoKanriNo(row.getShinseishoKanriNo());
                key.setNinteichosaRirekiNo(Integer.parseInt(row.getNinteichosaRirekiNo().toString()));
                keyJoho.add(key);
            }
        }
        param.setKeyJoho(keyJoho);
        RString 調査実施日FROM = RString.EMPTY;
        RString 調査実施日TO = RString.EMPTY;
        if (div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue() != null) {
            調査実施日FROM = div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue().toDateString();
        }
        if (div.getChosaJisshibi().getTxtChosaJisshibi().getToValue() != null) {
            調査実施日TO = div.getChosaJisshibi().getTxtChosaJisshibi().getToValue().toDateString();
        }
        param.setChosaKijunbiFrom(調査実施日FROM);
        param.setChosaKijunbiTo(調査実施日TO);
        param.setChosaKijunbiKubun(div.getRadKijunbi().getSelectedKey());
        param.setHokensya(div.getChosaJisshibi().getCcdHokensya().getSelectedItem().get市町村コード().value());
        param.setShokisaiHokensya(div.getChosaJisshibi().getCcdHokensya().getSelectedItem().get証記載保険者番号().value());
        param.setSyohyoSyuturyoku(帳票出力区分);
        return param;
    }

    private RString dataFormat(RString data) {
        if (RString.isNullOrEmpty(data)) {
            return RString.EMPTY;
        }
        RDate date_tmp = new RDate(data.toString());
        return date_tmp.wareki().toDateString();
    }

}
