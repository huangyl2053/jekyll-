/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.EnkiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定延期通知書発行一覧表ボディEditorです。
 *
 * @reamsid_L DBD-1410-040 chenxin
 */
class NinteiEnkiTsuchishoHakkoIchiranhyoBodyEditor implements INinteiEnkiTsuchishoHakkoIchiranhyoEditor {

    private final EnkiTsuchishoEntity entity;

    protected NinteiEnkiTsuchishoHakkoIchiranhyoBodyEditor(EnkiTsuchishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定延期通知書発行一覧表ボディEditorです。
     *
     * @param source NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     * @return source NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     */
    @Override
    public NinteiEnkiTsuchishoHakkoIchiranhyoReportSource edit(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        editNo(source);
        edit被保番号(source);
        edit氏名(source);
        edit住所(source);
        edit申請日(source);
        edit延期決定年月日(source);
        edit延期理由(source);
        edit延期通知発行年月日(source);
        edit延期通知書発行回数(source);
        edit延期見込期間開始年月日(source);
        edit延期見込期間終了年月日(source);
        return source;
    }

    private void editNo(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_1 = new RString(entity.get連番());
    }

    private void edit被保番号(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_2 = entity.get被保番号();
        source.shikibetsuCode = RString.EMPTY;
        source.hihokenshaNo = entity.get被保番号();
    }

    private void edit氏名(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (entity.get氏名() != null) {
            source.listHakkoIchiranhyo_3 = entity.get氏名().getColumnValue();
        }
    }

    private void edit住所(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (entity.get住所() != null) {
            source.listHakkoIchiranhyo_4 = entity.get住所().getColumnValue();
        }
    }

    private void edit申請日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_5 = entity.get申請日() == null ? RString.EMPTY : entity.get申請日()
                .wareki().toDateString();
    }

    private void edit延期決定年月日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source){
        source.listHakkoIchiranhyo_6 = entity.get延期決定年月日() == null ? RString.EMPTY : entity.get延期決定年月日().wareki().toDateString();
    }
    
    private void edit延期理由(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source){
        source.listHakkoIchiranhyo_7 = entity.get延期理由() == null ? RString.EMPTY : entity.get延期理由();
    }
    
    private void edit延期通知発行年月日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_8 = entity.get延期通知発行年月日() == null ? RString.EMPTY : entity.get延期通知発行年月日().wareki().toDateString();
    }
    
     private void edit延期通知書発行回数(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_9 = new RString(entity.get延期通知発行回数());
    }
   
    private void edit延期見込期間開始年月日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_10 = entity.get延期見込期間開始年月日() == null ? RString.EMPTY : entity.get延期見込期間開始年月日().wareki().toDateString();
    }
    
    private void edit延期見込期間終了年月日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_11 = entity.get延期見込期間開始年月日() == null ? RString.EMPTY : entity.get延期見込期間開始年月日().wareki().toDateString();
    }
    
    private boolean isコードNullOrEmpty(Code コード) {
        return null == コード || コード.isEmpty();
    }
}
