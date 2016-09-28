/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200003_事業合算・事業分振込明細書作成（一括） HeaderEditorクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranHeaderEditor implements IFurikomiMeisaiIchiranEditor {

    private final FurikaeGoMeisaiEntity 振込明細一覧Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     */
    public FurikomiMeisaiIchiranHeaderEditor(FurikaeGoMeisaiEntity 振込明細一覧Entity) {
        this.振込明細一覧Entity = 振込明細一覧Entity;
    }

    @Override
    public FurikomiMeisaiIchiranSource edit(FurikomiMeisaiIchiranSource source) {

        source.shiharaihoho = 振込明細一覧Entity.get支払方法();
        source.kikan = 振込明細一覧Entity.get抽出範囲();
        if (振込明細一覧Entity.get作成日() != null) {
            source.hyouzi_ymd1 = new RString(振込明細一覧Entity.get作成日().toString());
        }
        if (振込明細一覧Entity.get依頼日() != null) {
            source.hyouzi_ymd2 = new RString(振込明細一覧Entity.get依頼日().toString());
        }
        if (振込明細一覧Entity.get振込指定日() != null) {
            source.hyouzi_ymd3 = new RString(振込明細一覧Entity.get振込指定日().toString());
        }

        source.pageCnt = new RString(振込明細一覧Entity.get頁());
        if (振込明細一覧Entity.get作成年月日と時間() != null) {
            source.shori_ymd_hms = new RString(振込明細一覧Entity.get作成年月日と時間().toString());
        }

        if (振込明細一覧Entity.get市町村コード() != null) {
            source.hokensha_cd = 振込明細一覧Entity.get市町村コード().value();
        }
        source.hokensha_name = 振込明細一覧Entity.get市町村名();

        source.sort_nm1 = 振込明細一覧Entity.get並び順１();
        source.sort_nm2 = 振込明細一覧Entity.get並び順２();
        source.sort_nm3 = 振込明細一覧Entity.get並び順３();
        source.sort_nm4 = 振込明細一覧Entity.get並び順４();
        source.sort_nm5 = 振込明細一覧Entity.get並び順５();

        return source;
    }

}
