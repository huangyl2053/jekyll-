/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定延期通知書発行一覧表Entityクラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EnkiTsuchishoEntity {

    private Code 厚労省IF識別コード;
    private RString 被保番号;
    private AtenaMeisho 氏名;
    private AtenaKanaMeisho 氏名カナ;
    private AtenaJusho 住所;
    private FlexibleDate 申請日;
    private RString 申請理由;
    private FlexibleDate 一次判定年月日;
    private Code 一次判定結果コード;
    private Code 一五次判定結果コード;
    private FlexibleDate 資料作成日;
    private FlexibleDate 審査会予定日;
    private int 延期通知発行回数;
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定開始日;
    private FlexibleDate 前回認定終了日;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private FlexibleDate 処理見込み日From;
    private FlexibleDate 処理見込み日To;
    private FlexibleDate 通知書発行日;
    private int 連番;
}
