/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転入転出未登録一覧表ボディEditorです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
class TennyuTenshutsuMiTorokuIchiranhyoBodyEditor implements ITennyuTenshutsuMiTorokuIchiranhyoEditor {

    private static final int INDEX_26 = 26;
    private static final int INDEX_13 = 13;
    private final TennyuTenshutsuMiTorokuIchiranhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TennyuTenshutsuMiTorokuIchiranhyoBodyItem}
     */
    protected TennyuTenshutsuMiTorokuIchiranhyoBodyEditor(TennyuTenshutsuMiTorokuIchiranhyoBodyItem item) {
        this.item = item;
    }

    /**
     * 転入転出未登録一覧表editです。
     *
     * @param reportSourceWriter 転入転出未登録一覧表Source
     * @return TennyuTenshutsuMitorokuIchiranhyoReportSource
     */
    @Override
    public TennyuTenshutsuMitorokuIchiranhyoReportSource edit(TennyuTenshutsuMitorokuIchiranhyoReportSource source) {
        return editBody(source);
    }

    private TennyuTenshutsuMitorokuIchiranhyoReportSource editBody(TennyuTenshutsuMitorokuIchiranhyoReportSource source) {
        source.listUpper_1 = item.getデータ内容();
        source.listUpper_2 = item.get市町村コード();
        source.listUpper_3 = item.get市町村名();
        source.listUpper_4 = item.get住民状態();
        source.listUpper_5 = item.get異動事由コード();
        source.listUpper_6 = item.get異動事由();
        source.listUpper_7 = item.get住所地特例();
        RString 住所 = item.get住所();
        source.listUpper_8 = RString.isNullOrEmpty(住所) ? RString.EMPTY : maxLength26(住所);
        source.listMiddle_1 = item.get識別コード();
        RString カナ氏名 = item.getカナ氏名();
        source.listMiddle_2 = RString.isNullOrEmpty(カナ氏名) ? RString.EMPTY : maxLength26(カナ氏名);
        source.listMiddle_3 = item.get生年月日();
        source.listMiddle_4 = item.get性別();
        source.listMiddle_5 = item.get登録異動日();
        source.listMiddle_6 = item.get消除異動日();
        source.listMiddle_7 = item.get転出予定異動日();
        RString 転出予定住所前住所 = item.get転出予定住所前住所();
        source.listMiddle_8 = RString.isNullOrEmpty(転出予定住所前住所) ? RString.EMPTY : maxLength26(転出予定住所前住所);
        source.listMiddle_9 = item.get作成事由コードMiddle();
        source.listMiddle_10 = item.get作成事由Middle();
        source.listLower_1 = item.get世帯コード();
        RString 氏名 = item.get氏名();
        source.listLower_2 = RString.isNullOrEmpty(氏名) ? RString.EMPTY : maxLength13(氏名);
        source.listLower_3 = item.get登録届出日();
        source.listLower_4 = item.get消除届出日();
        return source;
    }

    private RString maxLength26(RString data) {
        if (data.length() > INDEX_26) {
            return data.substring(0, INDEX_26);
        } else {
            return data;
        }
    }

    private RString maxLength13(RString data) {
        if (data.length() > INDEX_13) {
            return data.substring(0, INDEX_13);
        } else {
            return data;
        }
    }
}
